import java.util.*;
import java.io.*;

/* 
This follows the same idea of Solution2 but instead of using maps,
we use arrays for simpler syntax. In this array, the indexes represent
the sum and the value stored is the frequency.
 */
public class Solution3 {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int tc = 1;
        while (in.hasNextInt()) {
            int n = in.nextInt();
            int m = in.nextInt();
            int max = -1;
            int[] sumCount = new int[n + m + 1];
            for (int a = 1; a <= n; a++) {
                for (int b = 1; b <= m; b++) {
                    int sum = a + b;
                    sumCount[sum]++;
                    max = Math.max(max, sumCount[sum]);
                }
            }
            System.out.println("Test Case " + tc + ":");
            for (int i = 1; i < sumCount.length; i++)
                if (sumCount[i] == max)
                    System.out.println(i);
            tc++;
        }
    }
}