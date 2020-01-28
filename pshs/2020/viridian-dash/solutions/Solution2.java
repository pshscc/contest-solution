
/**
 * @author Shakeel Samsudeen
 */

import java.io.*;
import java.util.*;

public class Solution2 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int sR = 0, sC = 0;
            char[][] map = new char[r][c];
            int[][] path = new int[r][c];
            Position[][] positions = new Position[r][c];
            for (int i = 0; i < r; i++) {
                String line = in.readLine();
                for (int j = 0; j < c; j++) {
                    map[i][j] = line.charAt(j);
                    path[i][j] = Integer.MAX_VALUE;
                    if (map[i][j] == '#') {
                        sR = i;
                        sC = j;
                        path[i][j] = 0;
                        positions[i][j] = new Position(i, j, 0);
                    }
                }
            }
            PriorityQueue<Position> pq = new PriorityQueue<Position>();
            ArrayList<Position> save = new ArrayList<Position>();
            int min = Integer.MAX_VALUE;
            pq.add(new Position(sR, sC, 0));
            int[] dr = { -1, 0, 0, 1 };
            int[] dc = { 0, -1, 1, 0 };
            while (!pq.isEmpty()) {
                Position u = pq.poll();
                if (u.r == 0 || u.c == 0 || u.r == r - 1 || u.c == c - 1) {
                    if (u.x <= min) {
                        if (u.x < min)
                            save.clear();
                        save.add(u);
                        min = u.x;
                    }
                    continue;
                }
                for (int i = 0; i < 4; i++) {
                    int tR = u.r + dr[i];
                    int tC = u.c + dc[i];
                    if (tR < 0 || tC < 0 || tR >= r || tC >= c)
                        continue;
                    if (map[tR][tC] == 'T')
                        continue;
                    int x = u.x;
                    switch (map[tR][tC]) {
                    case '^':
                        if (u.r == tR + 1)
                            tR--;
                        else
                            continue;
                        break;
                    case 'v':
                        if (u.r == tR - 1)
                            tR++;
                        else
                            continue;
                        break;
                    case '<':
                        if (u.c == tC + 1)
                            tC--;
                        else
                            continue;
                        break;
                    case '>':
                        if (u.c == tC - 1)
                            tC++;
                        else
                            continue;
                        break;
                    }
                    switch (map[tR][tC]) {
                    case '!':
                        x += 3;
                        break;
                    default:
                        x++;
                        break;
                    }
                    if (x <= path[tR][tC]) {
                        Position v = positions[tR][tC] == null ? new Position(tR, tC, path[tR][tC] = x)
                                : positions[tR][tC];
                        v.ancestors.add(u);
                        if (positions[tR][tC] == null)
                            pq.add(v);
                        positions[tR][tC] = v;
                    }
                }
            }
            for (Position p : save) {
                Queue<Position> queue = new LinkedList<Position>();
                queue.add(p);
                while (!queue.isEmpty()) {
                    Position y = queue.poll();
                    if (!y.visited) {
                        y.visited = true;
                        map[y.r][y.c] = 'o';
                        queue.addAll(y.ancestors);
                    }
                }
            }
            map[sR][sC] = '#';
            out.println(save.get(0).x);
            for (char[] arr : map) {
                String temp = Arrays.toString(arr);
                out.println(temp.substring(1, temp.length() - 1).replaceAll(", ", ""));
            }
        }
        out.close();
    }
}

class Position implements Comparable<Position> {
    int r, c, x;
    ArrayList<Position> ancestors;
    boolean visited;

    public Position(int r, int c, int x) {
        this.r = r;
        this.c = c;
        this.x = x;
        ancestors = new ArrayList<Position>();
        visited = false;
    }

    public int compareTo(Position p) {
        return x - p.x;
    }

    public String toString() {
        return r + " " + c + " " + x;
    }
}