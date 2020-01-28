
/**
 * @author JB Ladera
 */

import java.io.*;
import java.util.*;

public class Solution2 {
    private static int MAX = (int) 2e5;

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int[] dp = new int[MAX + 1];
        int t = sc.nextInt();
        while (t-- > 0) {
            int e = sc.nextInt();
            int n = sc.nextInt();
            int[] exp = new int[n];
            int sum = 0;
            for (int x = 0; x < n; x++) {
                int experience = sc.nextInt();
                exp[x] = experience;
                sum += experience;
            }
            if (sum < e) {
                System.out.println(sum + " " + n);
                continue;
            }
            Arrays.fill(dp, MAX);
            dp[0] = 0;
            int min = MAX;
            for (int xp : exp) {
                for (int x = MAX; x >= xp; x--) {
                    if (dp[x - xp] != MAX) {
                        dp[x] = Math.min(dp[x], dp[x - xp] + 1);
                        if (x >= e)
                            min = Math.min(min, x);
                    }
                }
            }
            System.out.println(min + " " + dp[min]);
        }
    }
}