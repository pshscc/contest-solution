
/**
 * @author Shakeel Samsudeen
 */

import java.io.*;
import java.util.*;
import java.math.*;

public class Solution1 {
    private static double[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            dp = new double[51][51];
            for (int i = 0; i < dp.length; i++) {
                dp[i][0] = dp[i][i] = 1;
                for (int j = 1; j < i; j++)
                    dp[i][j] = -1;
            }
            StringTokenizer st = new StringTokenizer(in.readLine());
            int n = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            double w = 0.01 * Integer.parseInt(st.nextToken());

            if (x > n / 2) {
                out.println("Free health potions for all!");
            } else if (y >= (n + 1) / 2) {
                out.println("Free berries are alright...");
            } else {
                int m = n - x - y;
                double a = 0;
                for (int i = n / 2 + 1 - x; i <= m; i++) {
                    a += (double) choose(m, i) / Math.pow(2, m);
                }
                if (a > w) {
                    out.println("Free health potions for all!");
                } else {
                    out.println("Keep calm!");
                }
            }
        }
        out.close();
    }

    private static double choose(int n, int k) {
        if (dp[n][k] > 0)
            return dp[n][k];
        return dp[n][k] = choose(n - 1, k - 1) + choose(n - 1, k);
    }
}