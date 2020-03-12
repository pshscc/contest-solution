
/**
 * @author JB Ladera
 * Solution using BFS
 */

import java.io.*;
import java.util.*;
import java.math.*;

public class Solution2 {
    static int m, t;
    static HashMap<String, Integer> index; // map names to numbers
    static ArrayList<ArrayList<Integer>> nodes; // adjacency list
    static int[] count;
    // the count array represents how many people watched an anime on a given day
    // e.g. count[4] indicates the number of people that watched an anime on day 4

    static int MAX = 1500;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        m = sc.nextInt();

        index = new HashMap<>();
        nodes = new ArrayList<>(m);

        for (int x = 0; x < m; x++) {
            index.put(sc.next(), x);
            nodes.add(new ArrayList<>());
        }

        // build adjacency list
        for (int x = 0; x < m; x++) {
            int n = sc.nextInt();
            for (int a = 0; a < n; a++)
                nodes.get(x).add(index.get(sc.next()));
        }

        t = sc.nextInt();
        StringBuilder ans = new StringBuilder();
        while (t-- > 0) {
            String s = sc.next();
            int node = index.get(s);
            bfs(node);
            int total = 0;
            int X = 0, D = 0, E = 0;
            for (int x = 0; x <= MAX; x++) {
                total += count[x];
                if (count[x] > 0)
                    E = x + 1;
                if (count[x] > X && x != 0) {
                    X = count[x];
                    D = x;
                }
            }
            if (total == 1) {
                ans.append(0);
            } else {
                if (total != m)
                    E = -1;
                ans.append(D).append(' ').append(X).append(' ').append(E);
            }
            ans.append('\n');
        }
        System.out.print(ans);
    }

    static void bfs(int source) {
        boolean[] visit = new boolean[m]; // visit array to prevent visiting someone twice
        count = new int[MAX + 1];
        Queue<Node> q = new LinkedList<>();
        Node init = new Node(source, 0);
        q.offer(init);
        visit[source] = true;
        count[0]++;
        while (!q.isEmpty()) {
            Node cur = q.poll();
            for (int person : nodes.get(cur.person)) {
                if (visit[person])
                    continue;
                visit[person] = true;
                count[cur.day + 1]++;
                q.offer(new Node(person, cur.day + 1));
            }
        }
    }

    static class Node {
        int day, person;

        public Node(int person, int day) {
            this.person = person;
            this.day = day;
        }
    }
}