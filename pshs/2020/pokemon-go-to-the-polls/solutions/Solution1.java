
/**
 * @author Shakeel Samsudeen
 */

import java.io.*;
import java.util.*;

public class Solution1 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        double[][] dp = new double[51][51];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0 || i == j)
                    dp[i][j] = 1;
                else
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
            }
        }
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
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
                    a += dp[m][i] / Math.pow(2, m);
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
}