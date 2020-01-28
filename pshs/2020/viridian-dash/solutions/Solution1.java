
/**
 * @author JB Ladera
 */

import java.io.*;
import java.util.*;

@SuppressWarnings("unchecked")
public class Solution1 {
    private static char[][] map;
    private static int[][] times;

    private static int[] dx = { -1, 1, 0, 0 }, dy = { 0, 0, -1, 1 };

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        StringBuilder ans = new StringBuilder();
        int T = sc.nextInt();
        while (T-- > 0) {
            int R = sc.nextInt();
            int C = sc.nextInt();
            sc.nextLine();
            map = new char[R][C];
            times = new int[R][C];
            HashSet<Point>[][] connect = new HashSet[R][C];
            int startR = 0, startC = 0;
            for (int r = 0; r < R; r++) {
                map[r] = sc.nextLine().toCharArray();
                for (int c = 0; c < C; c++) {
                    times[r][c] = Integer.MAX_VALUE;
                    connect[r][c] = new HashSet<>();
                    if (map[r][c] == '#') {
                        startR = r;
                        startC = c;
                        times[r][c] = 0;
                    }
                }
            }
            int minTime = Integer.MAX_VALUE;
            times[startR][startC] = 0;
            PriorityQueue<Point> q = new PriorityQueue<>();
            ArrayDeque<Point> shortest = new ArrayDeque<>(100);
            q.offer(new Point(startR, startC, 0));
            while (!q.isEmpty()) {
                Point cur = q.poll();
                if (cur.r == 0 || cur.c == 0 || cur.r == R - 1 || cur.c == C - 1) {
                    if (cur.t < minTime) {
                        minTime = cur.t;
                        shortest.clear();
                        shortest.addLast(cur);
                    } else if (cur.t == minTime) {
                        shortest.addLast(cur);
                    }
                    continue;
                }
                for (int x = 0; x < 4; x++) {
                    int r = cur.r + dx[x];
                    int c = cur.c + dy[x];
                    if (r < 0 || c < 0 || r == R || c == C)
                        continue;
                    char obs = map[r][c];
                    if (obs == 'T' || obs == '#')
                        continue;
                    int time;
                    if (obs == '!' || obs == '.' || obs == ' ') {
                        time = cur.t + (obs == '!' ? 3 : 1);
                        if (time < times[r][c]) {
                            q.offer(new Point(r, c, times[r][c] = time));
                            connect[r][c].clear();
                            connect[r][c].add(cur);
                        } else if (time == times[r][c]) {
                            connect[r][c].add(cur);
                        }
                    } else {
                        boolean jumpFence = false;
                        if (obs == '^' && dx[x] == -1) {
                            r--;
                            jumpFence = true;
                        } else if (obs == 'v' && dx[x] == 1) {
                            r++;
                            jumpFence = true;
                        } else if (obs == '<' && dy[x] == -1) {
                            c--;
                            jumpFence = true;
                        } else if (obs == '>' && dy[x] == 1) {
                            c++;
                            jumpFence = true;
                        }
                        if (jumpFence) {
                            obs = map[r][c];
                            time = cur.t + (obs == '!' ? 3 : 1);
                            if (time < times[r][c]) {
                                q.offer(new Point(r, c, times[r][c] = time));
                                connect[r][c].clear();
                                connect[r][c].add(cur);
                            } else if (time == times[r][c]) {
                                connect[r][c].add(cur);
                            }
                        }
                    }
                }
            }
            while (!shortest.isEmpty()) {
                Point cur = shortest.pollFirst();
                Queue<Point> p = new LinkedList<>();
                HashSet<Point> visit = new HashSet<>();
                visit.add(cur);
                p.offer(cur);
                while (!p.isEmpty()) {
                    Point a = p.poll();
                    map[a.r][a.c] = 'o';
                    for (Point other : connect[a.r][a.c])
                        if (visit.add(other))
                            p.offer(other);
                }
            }
            map[startR][startC] = '#';
            ans.append(minTime).append('\n');
            for (char[] r : map) {
                for (char c : r)
                    ans.append(c);
                ans.append('\n');
            }
        }
        System.out.print(ans);
    }

    private static class Point implements Comparable<Point> {
        int r, c, t;

        public Point(int row, int col, int time) {
            r = row;
            c = col;
            t = time;
        }

        public int compareTo(Point o) {
            return t - o.t;
        }

        public boolean equals(Object o) {
            Point other = (Point) o;
            return r == other.r && c == other.c && t == other.t;
        }

        public int hashCode() {
            return Objects.hash(r, c, t);
        }

        public String toString() {
            return String.format("{ %d %d %d }", r, c, t);
        }
    }
}