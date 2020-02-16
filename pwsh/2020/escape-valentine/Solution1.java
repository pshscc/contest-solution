import java.io.*;
import java.util.*;
import java.math.*;

public class Solution1 {
    static Scanner sc, in;
    static PrintWriter out;

    static int R, C;
    static char[][] map;
    static int[][] time;
    static Coord[][] tp = new Coord[200][2];

    static int[] dx = { -1, 1, 0, 0 }, dy = { 0, 0, -1, 1 };

    public static void main(String[] args) throws Exception {
        sc = in = new Scanner(System.in);
        out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        R = sc.nextInt();
        C = sc.nextInt();
        int sR = 0, sC = 0;
        int eR = 0, eC = 0;
        map = new char[R][C];
        time = new int[R][C];
        for (int r = 0; r < R; r++) {
            String line = sc.next();
            for (int c = 0; c < C; c++) {
                map[r][c] = line.charAt(c);
                time[r][c] = Integer.MAX_VALUE;
                if (map[r][c] == '$') {
                    eR = r;
                    eC = c;
                } else if (map[r][c] == '@') {
                    sR = r;
                    sC = c;
                } else if (Character.isLetter(map[r][c])) {
                    char let = map[r][c];
                    if (tp[let][0] == null) {
                        tp[let][0] = new Coord(r, c);
                    } else {
                        tp[let][1] = new Coord(r, c);
                    }
                }
            }
        }
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(sR, sC, 0));
        while (!q.isEmpty()) {
            Node cur = q.poll();
            if (cur.t >= time[cur.r][cur.c])
                continue;
            time[cur.r][cur.c] = cur.t;
            if (cur.r == eR && cur.c == eC)
                continue;
            for (int x = 0; x < dx.length; x++) {
                int r = cur.r + dx[x];
                int c = cur.c + dy[x];
                if (r < 0 || c < 0 || r >= R || c >= C || map[r][c] == '#')
                    continue;
                if (Character.isLetter(map[r][c])) {
                    int t = cur.t + 1;
                    char let = map[r][c];
                    Coord f = tp[let][0];
                    Coord s = tp[let][1];
                    if (f.r == r && f.c == c) {
                        r = s.r;
                        c = s.c;
                    } else {
                        r = f.r;
                        c = f.c;
                    }
                }
                int t = cur.t + 1;
                q.offer(new Node(r, c, t));
            }
        }
        out.println(time[eR][eC] == Integer.MAX_VALUE ? "Rip Valentines!" : time[eR][eC]);
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

    static class Coord {
        int r, c;

        public Coord(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
