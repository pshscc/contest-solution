
/**
 * @author JB Ladera
 */

import java.io.*;
import java.util.*;
import java.math.*;

public class Solution2 {
    static Scanner sc, in;
    static PrintWriter out;

    public static void main(String[] args) throws Exception {
        sc = in = new Scanner(System.in);
        out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = sc.nextInt();
        while (n-- > 0) {
            int m = sc.nextInt();
            Integer[] arr = factors(m);
            if (valid(m, arr))
                out.println("Semiperfect");
            else
                out.println("NOT Semiperfect");
        }
        out.close();
    }

    // alternatively there is a dynamic programming solution
    // for this type of problem, however, the test cases
    // weren't that strong so this was not needed.
    static boolean valid(int sum, Integer[] arr) {
        boolean[][] dp = new boolean[arr.length + 1][sum + 1];
        for (int r = 0; r <= arr.length; r++)
            dp[r][0] = true;
        for (int i = 1; i <= arr.length; i++) {
            int num = arr[i - 1];
            for (int j = 1; j <= sum; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= num)
                    dp[i][j] = dp[i][j] || dp[i - 1][j - num];
            }
        }
        return dp[arr.length][sum];
    }

    static Integer[] factors(int m) {
        // store factors in a set to prevent duplicates
        // due to the way im getting factors
        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        // get factors in O(sqrt(m)) time
        for (int x = 2; x < Math.sqrt(m) + 1; x++) {
            if (m % x == 0) {
                set.add(x);
                set.add(m / x);
            }
        }
        // return an array containing the factors
        return set.toArray(new Integer[set.size()]);
    }
}