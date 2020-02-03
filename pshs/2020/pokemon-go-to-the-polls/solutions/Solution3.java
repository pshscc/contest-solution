
/**
 * @author JB Ladera
 */

import java.io.*;
import java.util.*;

public class Solution3 {
    private static int MAX = 50;
    private static int n, x, y, w;
    private static long[][] dp = new long[MAX + 2][MAX + 2];

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            n = sc.nextInt();
            x = sc.nextInt();
            y = sc.nextInt();
            w = sc.nextInt();
            for (int a = n; a >= x; a--) {
                for (int b = n; b >= y; b--) {
                    if (a + b > n)
                        continue;
                    if (a + b == n)
                        dp[a][b] = a > n / 2 ? 1 : 0;
                    else
                        dp[a][b] = dp[a + 1][b] + dp[a][b + 1];
                }
            }
            int leftover = n - x - y;
            long wins = dp[x][y];
            long total = 1L << leftover; // pow(2, leftover)
            double percent = wins * 100d / total;
            if (percent > w)
                System.out.println("Free health potions for all!");
            else if (percent == 0)
                System.out.println("Free berries are alright...");
            else
                System.out.println("Keep calm!");
        }
    }
}