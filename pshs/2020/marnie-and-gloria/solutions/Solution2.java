
/**
 * @author JB Ladera
 */

import java.io.*;
import java.util.*;

public class Solution2 {
    private static int n, q;
    private static HashMap<String, Integer> index;

    private static ArrayList<ArrayList<Integer>> nodes;
    private static ArrayList<Integer> euler;
    private static int[] depth, first, segtree; // segment tree

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        q = sc.nextInt();

        first = new int[n + 1];
        depth = new int[n + 1];

        index = new HashMap<>();
        nodes = new ArrayList<>();
        euler = new ArrayList<>();
        for (int x = 0; x <= n; x++)
            nodes.add(new ArrayList<>());

        String[][] connections = new String[n - 1][2];
        Set<String> names = new HashSet<>();
        for (int x = 0; x < n - 1; x++) {
            String l1 = sc.next();
            String l2 = sc.next();
            sc.next();
            names.add(l1);
            names.add(l2);
            connections[x][0] = l1;
            connections[x][1] = l2;
        }
        int i = 1;
        for (String s : names)
            index.put(s, i++);
        for (int x = 0; x < n - 1; x++) {
            int a = index.get(connections[x][0]);
            int b = index.get(connections[x][1]);
            nodes.get(a).add(b);
            nodes.get(b).add(a);
        }
        dfs(1, 0);
        segtree = new int[euler.size() << 2];
        build(1, 0, euler.size() - 1);
        while (q-- > 0) {
            String A = sc.next();
            String B = sc.next();
            int a = index.get(A);
            int b = index.get(B);
            int d = depth[lca(a, b)];
            int dist = Math.abs(d - depth[a]) + Math.abs(d - depth[b]);
            int m = (int) Math.ceil(dist / 2d);
            int g = dist - m;
            System.out.println(m + " " + g);
        }
    }

    private static void dfs(int cur, int par) {
        first[cur] = euler.size();
        depth[cur] = depth[par] + 1;
        euler.add(cur);
        for (int node : nodes.get(cur)) {
            if (node != par) {
                dfs(node, cur);
                euler.add(cur);
            }
        }
    }

    private static void build(int node, int l, int r) {
        if (l == r) {
            segtree[node] = euler.get(l);
        } else {
            int m = (l + r) / 2;
            build(node * 2, l, m);
            build(node * 2 + 1, m + 1, r);
            int left = segtree[node * 2];
            int right = segtree[node * 2 + 1];
            segtree[node] = depth[left] < depth[right] ? left : right;
        }
    }

    private static int query(int node, int l, int r, int L, int R) {
        if (l > R || r < L)
            return -1;
        if (l >= L && r <= R)
            return segtree[node];
        int m = (l + r) / 2;
        int left = query(node * 2, l, m, L, R);
        int right = query(node * 2 + 1, m + 1, r, L, R);
        if (left == -1)
            return right;
        if (right == -1)
            return left;
        return depth[left] < depth[right] ? left : right;
    }

    private static int lca(int a, int b) {
        if (first[a] > first[b]) {
            int t = a;
            a = b;
            b = t;
        }
        return query(1, 0, euler.size() - 1, first[a], first[b]);
    }
}