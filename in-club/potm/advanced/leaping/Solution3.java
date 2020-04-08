
/**
 * @author JB Ladera
 */

import java.io.*;
import java.util.*;

public class Solution3 {
    static Scanner sc, in;
    static PrintWriter out;

    static int MAX = 500, MIN = 1;

    public static void main(String[] args) throws Exception {
        sc = in = new Scanner(System.in);
        out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = sc.nextInt();
        int q = sc.nextInt();
        int[] arr = new int[n + 1];
        for (int i = 1; i < arr.length; i++) {
            int[] a = new int[8];
            for (int x = 0; x < a.length; x++)
                a[x] = sc.nextInt();
            int leaps = count(a);
            arr[i] = Math.max(0, 50 - leaps);
        }
        for (int x = 1; x < arr.length; x++)
            arr[x] += arr[x - 1];
        while (q-- > 0) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            out.println(arr[r] - arr[l - 1]);
        }
        out.close();
    }

    static int count(int[] arr) {
        boolean[][] visit = new boolean[MAX + 1][MAX + 1];
        Queue<Coord> q = new ArrayDeque<>();
        q.offer(new Coord(arr[0], arr[1], 0));
        while (!q.isEmpty()) {
            Coord cur = q.poll();
            if (visit[cur.x][cur.y] || cur.l >= 50)
                continue;
            visit[cur.x][cur.y] = true;
            if (cur.x == arr[2] && cur.y == arr[3])
                return cur.l;
            int f = Math.min(MAX, cur.x + arr[4]); // forwards in x direction
            int b = Math.max(MIN, cur.x - arr[5]); // backwards in x direction
            q.offer(new Coord(f, cur.y, cur.l + 1));
            q.offer(new Coord(b, cur.y, cur.l + 1));
            f = Math.min(MAX, cur.y + arr[6]); // forwards in y direction
            b = Math.max(MIN, cur.y - arr[7]); // backwards in y direction
            q.offer(new Coord(cur.x, f, cur.l + 1));
            q.offer(new Coord(cur.x, b, cur.l + 1));
        }
        return 50;
    }

    static class Coord {
        int x, y, l; // x, y, number of leaps

        public Coord(int x, int y, int l) {
            this.x = x;
            this.y = y;
            this.l = l;
        }
    }
}