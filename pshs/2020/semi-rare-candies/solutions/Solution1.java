
/**
 * @author Shakeel Samsudeen
 */

import java.io.*;
import java.util.*;

public class Solution1 {
    private final static int INF = (int) 2e5;

    public static void main(String args[]) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            int exp = Integer.parseInt(in.readLine());
            int n = Integer.parseInt(in.readLine());
            int[] candies = new int[n];
            int sum = 0;
            for (int i = 0; i < n; i++) {
                candies[i] = Integer.parseInt(in.readLine());
                sum += candies[i];
            }
            int[] dp = new int[INF];
            Arrays.fill(dp, INF);
            dp[0] = 0;
            int index = INF;
            for (int i = 0; i < candies.length; i++) {
                int c = candies[i];
                for (int j = INF - 1; j >= c; j--) {
                    if (dp[j - c] != INF) {
                        dp[j] = Math.min(dp[j], dp[j - c] + 1);
                        if (j >= exp)
                            index = Math.min(j, index);
                    }
                }
            }
            out.println(sum < exp ? sum + " " + dp[sum] : index + " " + dp[index]);
        }
        out.close();
    }
}