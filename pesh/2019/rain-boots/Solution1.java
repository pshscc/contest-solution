import java.io.*;
import java.util.*;

public class Solution1 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("rain_boots.data"));
        int[] dx = { 0, 0, -1, 1 }, dy = { 1, -1, 0, 0 };
        int MAX = 8;
        while (sc.hasNextLine()) {
            int sR = 0, sC = 0;
            int eR = 0, eC = 0;
            char[][] map = new char[MAX][MAX];
            int[][] pud = new int[MAX][MAX];
            for (int r = 0; r < MAX; r++) {
                String line = sc.nextLine();
                for (int c = 0; c < MAX; c++) {
                    map[r][c] = line.charAt(c);
                    pud[r][c] = Integer.MAX_VALUE;
                    if (map[r][c] == 'S') {
                        sR = r;
                        sC = c;
                    } else if (map[r][c] == 'E') {
                        eR = r;
                        eC = c;
                    }
                }
            }
            Queue<Point> q = new LinkedList<>();
            q.offer(new Point(sR, sC, 0));
            pud[sR][sC] = 0;
            while (!q.isEmpty()) {
                Point cur = q.poll();
                if (cur.r == eR && cur.c == eC)
                    continue;
                for (int x = 0; x < 4; x++) {
                    int r = cur.r + dx[x];
                    int c = cur.c + dy[x];
                    if (r < 0 || c < 0 || r >= MAX || c >= MAX)
                        continue;
                    int p = cur.p + (map[r][c] == 'M' ? 1 : 0);
                    if (p < pud[r][c])
                        q.offer(new Point(r, c, pud[r][c] = p));
                }
            }
            System.out.println(pud[eR][eC]);
            try {
                sc.nextLine();
            } catch (Exception e) {
            }
        }
    }

    static class Point {
        int r, c, p;

        public Point(int q, int w, int e) {
            r = q;
            c = w;
            p = e;
        }
    }
}