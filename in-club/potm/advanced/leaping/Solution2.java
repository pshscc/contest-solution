
/**
 * @author Shakeel Samsudeen
 */

import java.io.*;
import java.util.*;

public class Solution2 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(in.readLine());

        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        int[] leaps = new int[n];
        Arrays.fill(leaps, 51);
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(in.readLine());
            Pos start = new Pos(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1);
            Pos end = new Pos(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1);
            int[] movements = { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };
            Queue<Pos> queue = new LinkedList<Pos>();
            queue.offer(start);
            long[][] visited = new long[500][500];
            for (long[] arr : visited)
                Arrays.fill(arr, 51);
            visited[start.x][start.y] = 0;
            while (!queue.isEmpty()) {
                if (start.equals(end)) {
                    leaps[i] = 50;
                    break;
                }
                Pos u = queue.poll();
                for (int m = 0; m < movements.length; m++) {
                    Pos v = null;
                    switch (m) {
                        case 0:
                            v = new Pos(u.x + movements[m], u.y);
                            break;
                        case 1:
                            v = new Pos(u.x - movements[m], u.y);
                            break;
                        case 2:
                            v = new Pos(u.x, u.y + movements[m]);
                            break;
                        case 3:
                            v = new Pos(u.x, u.y - movements[m]);
                            break;
                    }
                    if (!inBounds(v)) {
                        correct(v);
                    }
                    v.l = u.l + 1;
                    if (v.equals(end)) {
                        if (leaps[i] == 51)
                            leaps[i] = Math.min(leaps[i], 50 - v.l);
                        else
                            leaps[i] = Math.max(leaps[i], 50 - v.l);
                        if (v.l < visited[v.x][v.y] && v.l < visited[end.x][end.y])
                            visited[v.x][v.y] = v.l;
                        continue;
                    }
                    if (v.l < visited[v.x][v.y] && v.l < visited[end.x][end.y]) {
                        queue.offer(v);
                        visited[v.x][v.y] = v.l;
                    }
                }
            }
        }
        for (int l = 0; l < n; l++) {
            if (leaps[l] == 51 || leaps[l] < 0)
                leaps[l] = 0;
        }
        int[] prefix = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            prefix[i] = leaps[i - 1] + prefix[i - 1];
        }
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(in.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (a == b)
                out.println(leaps[a - 1]);
            else
                out.println(prefix[b] - prefix[a - 1]);
        }
        out.close();
    }

    public static boolean inBounds(Pos p) {
        return p.x >= 0 && p.y >= 0 && p.x < 500 && p.y < 500;
    }

    public static void correct(Pos p) {
        if (p.x < 0)
            p.x = 0;
        if (p.y < 0)
            p.y = 0;
        if (p.x >= 500)
            p.x = 499;
        if (p.y >= 500)
            p.y = 499;
    }
}

class Pos {
    int x;
    int y;
    int l;

    public Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean equals(Object o) {
        Pos p = (Pos) o;
        return p.x == x && p.y == y;
    }

    public String toString() {
        return x + " " + y;
    }
}