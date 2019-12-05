import java.io.*;
import java.util.*;

public class Solution1 {
    static Scanner sc, in;
    static PrintWriter out;

    static int R, C;
    static int[][] times;
    static char[][] map;
    static int[] dx = { 0, 0, -1, 1 }, dy = { 1, -1, 0, 0 };

    public static void main(String[] args) throws Exception {
        sc = in = new Scanner(System.in);
        out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        while (sc.hasNextLine()) {
            String[] line = sc.nextLine().split("/");
            R = Integer.parseInt(line[1]);
            C = Integer.parseInt(line[0]);
            int sR, sC, eR, eC;
            sR = sC = eR = eC = 0;
            times = new int[R][C];
            map = new char[R][C];
            for (int r = 0; r < R; r++) {
                map[r] = sc.nextLine().toCharArray();
                for (int c = 0; c < C; c++) {
                    times[r][c] = Integer.MAX_VALUE;
                    if (map[r][c] == 'S') {
                        sR = r;
                        sC = c;
                    } else if (map[r][c] == 'D') {
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
                if (map[cur.r][cur.c] == 'D')
                    continue;
                for (int x = 0; x < 4; x++) {
                    int r = cur.r + dx[x];
                    int c = cur.c + dy[x];
                    if (outbounds(r, c) || map[r][c] == 'W' || map[cur.r][cur.c] == '^' && dx[x] == 1
                            || map[cur.r][cur.c] == 'V' && dx[x] == -1 || map[cur.r][cur.c] == '<' && dy[x] == 1
                            || map[cur.r][cur.c] == '>' && dy[x] == -1)
                        continue;
                    char obs = map[r][c];
                    int s = cur.s + 1;
                    if (obs == '^' || obs == 'V' || obs == '<' || obs == '>') {
                        HashSet<A> arr = move(r, c);
                        for (A a : arr) {
                            r = a.r;
                            c = a.c;
                            if (s < times[r][c])
                                q.offer(new A(r, c, times[r][c] = s));
                        }
                    } else {
                        if (s < times[r][c])
                            q.offer(new A(r, c, times[r][c] = s));
                    }
                }
            }
            if (times[eR][eC] == Integer.MAX_VALUE)
                out.println("Not solvable.");
            else
                out.println("The fastest solution is " + times[eR][eC] + " step(s).");
        }
        out.close();
    }

    static HashSet<A> move(int r, int c) {
        HashSet<A> arr = new HashSet<>();
        arr.add(new A(r, c, 0));
        for (;;) {
            char obs = map[r][c];
            int nr = r;
            int nc = c;
            if (obs == '^')
                nr--;
            else if (obs == 'V')
                nr++;
            else if (obs == '<')
                nc--;
            else if (obs == '>')
                nc++;
            if (outbounds(nr, nc) || map[nr][nc] == 'W') {
                arr.add(new A(r, c, 0));
                break;
            }
            if (map[nr][nc] == 'D' || map[nr][nc] == 'S' || map[nr][nc] == '-') {
                arr.add(new A(nr, nc, 0));
                break;
            }
            r = nr;
            c = nc;
            arr.add(new A(r, c, 0));
        }
        return arr;
    }

    static boolean outbounds(int r, int c) {
        return r < 0 || c < 0 || r >= R || c >= C;
    }

    static class A implements Comparable<A> {
        int r, c, s;

        public A(int q, int w, int e) {
            r = q;
            c = w;
            s = e;
        }

        public int compareTo(A other) {
            return s - other.s;
        }

        public boolean equals(Object o) {
            A other = (A) o;
            return r == other.r && c == other.c && s == other.s;
        }

        public int hashCode() {
            return Objects.hash(r, c, s);
        }
    }
}