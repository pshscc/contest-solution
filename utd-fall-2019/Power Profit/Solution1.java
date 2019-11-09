import java.io.*;
import java.util.*;
import java.math.*;

public class Solution1 {
    static Scanner sc, in;

    public static void main(String[] args) throws Exception {
        sc = in = new Scanner(System.in);
        int n = sc.nextInt();
        int[] num = new int[n];
        for (int x = 0; x < n; x++)
            num[x] = sc.nextInt();
        int max, min;
        int profit = 0;
        max = min = Integer.MAX_VALUE;
        for (int x = 0; x < n; x++) {
            int p = num[x];
            if (p < min) {
                profit = Math.max(profit, max - min);
                min = max = p;
            } else
                max = Math.max(max, p);
        }
        profit = Math.max(profit, max - min);
        System.out.println(profit);
    }
}