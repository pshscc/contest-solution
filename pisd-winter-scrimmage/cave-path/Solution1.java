import java.io.*;
import java.util.*;

public class Solution1 {
    static Scanner sc, in;
    static PrintWriter out;
    static int R, C;
    static char[][] map;
    static int[][] times;
    static int[] dx = { 0, 0, -1, 1 }, dy = { 1, -1, 0, 0 };

    public static void main(String[] args) throws Exception {
        sc = in = new Scanner(System.in);
        out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        while (sc.hasNextLine()) {
            int sR, sC, eR, eC;
            sR = sC = eR = eC = 0;
            ArrayList<String> list = new ArrayList<>();
            for (;;) {
                String line = sc.nextLine();
                if (line.equals("*"))
                    break;
                list.add(line);
            }
            R = list.size();
            C = list.get(0).length();
            map = new char[R][C];
            times = new int[R][C];
            for (int r = 0; r < R; r++) {
                map[r] = list.get(r).toCharArray();
                for (int c = 0; c < C; c++) {
                    times[r][c] = Integer.MAX_VALUE;
                    if (map[r][c] == 'S') {
                        sR = r;
                        sC = c;
                    } else if (map[r][c] == 'E') {
                        eR = r;
                        eC = c;
                    }
                }
            }
            PriorityQueue<A> q = new PriorityQueue<>();
            q.offer(new A(sR, sC, 0));
            times[sR][sC] = 0;
            while (!q.isEmpty()) {
                A cur = q.poll();
                if (cur.r == eR && cur.c == eC)
                    continue;
                for (int x = 0; x < 4; x++) {
                    int r = cur.r + dx[x];
                    int c = cur.c + dy[x];
                    if (r < 0 || c < 0 || r >= R || c >= C)
                        continue;
                    int time = cur.t + (map[r][c] == '-' ? 1 : (map[r][c] == 'E' ? 0 : 2));
                    if (time < times[r][c])
                        q.offer(new A(r, c, times[r][c] = time));
                }
            }
            out.println("The fastest time would be " + times[eR][eC] + " day(s).");
        }
        out.close();
    }

    static class A implements Comparable<A> {
        int r, c, t;

        public A(int a, int b, int d) {
            r = a;
            c = b;
            t = d;
        }

        public int compareTo(A other) {
            return t - other.t;
        }
    }
}