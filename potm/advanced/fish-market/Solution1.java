/*
Solution by JB Ladera based off Shakeel's solution (Solution2.java)
Time complexity: O(nlog(n) + n) = O(nlog(n))
Sorting takes O(nlog(n)) and simulation takes O(n) so this
simplifies to O(nlog(n)).

To achieve the fastest runtime, you must recognize that
you have to ways of making money: selling each fish and selling consecutively.
Therefore, the Max Profit = NM + summation_{i=1}^{D} Ai+B
where D is the maximum consecutive day of selling fish.
If we use the summation of an arithmetic series (https://www.purplemath.com/modules/series4.htm),
we can get the formula to be: Max Profit = NM + D(A + B + AD + B) / 2
With this, we can simply calculate D through the simulation and
avoid multiple calls with BigInteger since BigInteger is similar
to String and utilizing methods are a heavy task.
We can then use the formula at the end to get the Max Profit.
*/

import java.io.*;
import java.util.*;
import java.math.*;

public class Solution1 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long m = sc.nextInt();
        long a = sc.nextInt();
        long b = sc.nextInt();
        int[] spoiled = new int[n];
        for (int x = 0; x < n; x++)
            spoiled[x] = sc.nextInt();
        Arrays.sort(spoiled);
        int day = 0;
        long streak = 0;
        // start at x = 1 to avoid counting the first fish as the start of the streak.
        // example test case: (correct answer is 4, but if you start at x = 1, it
        // outputs 7)
        // 2 1 1 1
        // 2 3
        for (int x = 1; x < n; x++) {
            if (spoiled[x] - 1 != day) {
                day++;
                streak++;
            }
        }
        BigInteger fishCost = BigInteger.valueOf(n * m);
        BigInteger part = BigInteger.valueOf(a + b + a * streak + b);
        BigInteger sum = BigInteger.valueOf(streak).multiply(part).divide(BigInteger.valueOf(2));
        BigInteger total = sum.add(fishCost);
        System.out.println(total);
    }
}