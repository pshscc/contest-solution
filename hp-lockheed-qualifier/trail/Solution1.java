
/**
 * @author JB Ladera
 */

import java.io.*;
import java.util.*;
import java.math.*;

public class Solution1 {
    static Scanner sc, in;
    static PrintWriter out;

    static int[] dx = { 0, 0, 1, -1 }, dy = { 1, -1, 0, 0 };

    public static void main(String[] args) throws Exception {
        sc = in = new Scanner(System.in);
        out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int t = sc.nextInt();
        while (t-- > 0) {
            int R = sc.nextInt();
            int C = sc.nextInt();
            sc.nextLine();
            char[][] map = new char[R][C];
            int[][] time = new int[R][C];
            int sR = 0, sC = 0;
            for (int r = 0; r < R; r++) {
                String line = sc.nextLine();
                for (int c = 0; c < C; c++) {
                    map[r][c] = line.charAt(c);
                    time[r][c] = Integer.MAX_VALUE;
                    if (map[r][c] == 'S') {
                        sR = r;
                        sC = c;
                    }
                }
            }
            Queue<Node> q = new LinkedList<>();
            q.offer(new Node(sR, sC, 0));
            time[sR][sC] = 0;
            while (!q.isEmpty()) {
                Node cur = q.poll();
                for (int x = 0; x < dx.length; x++) {
                    int r = cur.r + dx[x];
                    int c = cur.c + dy[x];
                    if (r < 0 || c < 0 || r >= R || c >= C || map[r][c] == 'R')
                        continue;
                    int curT = cur.t;
                    if (map[cur.r][cur.c] == '.')
                        curT += 3;
                    else if (map[cur.r][cur.c] == 'W')
                        curT += 8;
                    else if (map[cur.r][cur.c] == 'F')
                        curT += 5;
                    if (curT < time[r][c]) {
                        time[r][c] = curT;
                        q.offer(new Node(r, c, curT));
                    }
                }
            }
            int n = sc.nextInt();
            int min = Integer.MAX_VALUE;
            for (int r = 0; r < R; r++)
                min = Math.min(min, time[r][0]);
            if (min <= n)
                out.printf("The Package arrived with %d day(s) to spare.\n", n - min);
            else
                out.println("The Package was not delivered in time.");
        }
        out.close();
    }

    static class Node {
        int r, c, t;

        public Node(int r, int c, int t) {
            this.r = r;
            this.c = c;
            this.t = t;
        }
    }
}