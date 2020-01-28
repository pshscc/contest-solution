
/**
 * @author JB Ladera
 */

import java.io.*;
import java.util.*;

public class Solution2 {
    private static int MAX = 50;
    private static int n, x, y, w;
    private static long[][][] dp;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            dp = new long[MAX + 1][MAX + 1][MAX + 1];
            for (long[][] r : dp)
                for (long[] c : r)
                    Arrays.fill(c, -1);
            n = sc.nextInt();
            x = sc.nextInt();
            y = sc.nextInt();
            w = sc.nextInt();
            int leftover = n - x - y;
            long wins = rec(leftover, x, y);
            long count = (long) Math.pow(2, leftover);
            double res = wins * 100d / count;
            if (res > w)
                System.out.println("Free health potions for all!");
            else if (res == 0)
                System.out.println("Free berries are alright...");
            else
                System.out.println("Keep calm!");
        }
    }

    private static long rec(int leftover, int a, int b) {
        if (dp[leftover][a][b] != -1)
            return dp[leftover][a][b];
        if (leftover == 0) {
            if (a > n / 2)
                return dp[leftover][a][b] = 1;
            return dp[leftover][a][b] = 0;
        } else {
            long l = dp[leftover - 1][a + 1][b] = rec(leftover - 1, a + 1, b);
            long r = dp[leftover - 1][a][b + 1] = rec(leftover - 1, a, b + 1);
            return dp[leftover][a][b] = l + r;
        }
    }
}