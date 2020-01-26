
/**
 * @author JB Ladera
 */

import java.io.*;
import java.util.*;

public class Solution1 {
    private static int n, q;
    private static HashMap<String, Integer> index;

    private static ArrayList<ArrayList<Integer>> nodes;
    private static int[] depth;
    private static int[][] p;
    // sparse matrix

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        q = sc.nextInt();

        depth = new int[n];
        p = new int[20][n];
        index = new HashMap<>();
        nodes = new ArrayList<>();
        for (int x = 0; x < n; x++)
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
        int i = 0;
        for (String s : names)
            index.put(s, i++);
        for (int x = 0; x < n - 1; x++) {
            int a = index.get(connections[x][0]);
            int b = index.get(connections[x][1]);
            nodes.get(a).add(b);
            nodes.get(b).add(a);
        }
        build(0, 0, 0);
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

    private static void build(int node, int par, int dep) {
        depth[node] = dep;
        p[0][node] = par;
        for (int x = 1; x < p.length; x++)
            p[x][node] = p[x - 1][p[x - 1][node]];
        for (int x : nodes.get(node))
            if (x != par)
                build(x, node, dep + 1);
    }

    private static int lca(int a, int b) {
        if (depth[a] < depth[b]) {
            int t = a;
            a = b;
            b = t;
        }
        int c = depth[a] - depth[b];
        for (int x = 0; x < p.length; x++)
            if ((c >> x & 1) == 1)
                a = p[x][a];
        if (a == b)
            return a;
        for (int x = p.length - 1; x >= 0; x--)
            if (p[x][a] != p[x][b]) {
                a = p[x][a];
                b = p[x][b];
            }
        return p[0][a];
    }
}