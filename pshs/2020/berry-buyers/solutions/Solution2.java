
/**
 * @author JB ladera
 */

import java.io.*;
import java.util.*;
import java.math.*;

public class Solution2 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long m = sc.nextInt();
        long a = sc.nextInt();
        long b = sc.nextInt();
        int[] fresh = new int[n];
        for (int x = 0; x < n; x++)
            fresh[x] = sc.nextInt();
        Arrays.sort(fresh);
        int day = 0;
        long streak = 0;
        for (int x = 1; x < n; x++) {
            if (fresh[x] - 1 != day) {
                day++;
                streak++;
            }
        }
        BigInteger berryCost = BigInteger.valueOf(n * m);
        BigInteger part = BigInteger.valueOf(a + b + a * streak + b);
        BigInteger sum = BigInteger.valueOf(streak).multiply(part).divide(BigInteger.valueOf(2));
        BigInteger total = sum.add(berryCost);
        System.out.println(total);
    }
}