
/**
 * @author JB Ladera
 */

import java.io.*;
import java.util.*;

public class Solution1 {
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
            int leaps = count(a[0], a[2], a[4], a[5]) + count(a[1], a[3], a[6], a[7]);
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

    static int count(int start, int end, int f, int b) {
        boolean[] visit = new boolean[MAX + 1];
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] { start, 0 });
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (visit[cur[0]] || cur[1] >= 50)
                continue;
            visit[cur[0]] = true;
            if (cur[0] == end)
                return cur[1];
            int f1 = Math.min(MAX, cur[0] + f);
            int b1 = Math.max(MIN, cur[0] - b);
            q.offer(new int[] { f1, cur[1] + 1 });
            q.offer(new int[] { b1, cur[1] + 1 });
        }
        return 50;
    }
}