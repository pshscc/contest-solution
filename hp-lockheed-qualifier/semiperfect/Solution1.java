
/**
 * @author JB Ladera
 */

import java.io.*;
import java.util.*;
import java.math.*;

public class Solution1 {
    static Scanner sc, in;
    static PrintWriter out;

    public static void main(String[] args) throws Exception {
        sc = in = new Scanner(System.in);
        out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = sc.nextInt();
        while (n-- > 0) {
            int m = sc.nextInt();
            Integer[] arr = factors(m);
            if (valid(0, m, arr))
                out.println("Semiperfect");
            else
                out.println("NOT Semiperfect");
        }
        out.close();
    }

    // this problem is basically a subset sum problem which is
    // basically with an array of numbers, A, is it possible to make
    // a number N with any of the numbers in A?
    // this is the same idea as the groupSum problem on CodingBat under
    // Recursion-2 (https://codingbat.com/prob/p145416)
    static boolean valid(int x, int sum, Integer[] arr) {
        if (sum == 0)
            return true;
        if (x >= arr.length)
            return false;
        if (valid(x + 1, sum - arr[x], arr))
            return true;
        if (valid(x + 1, sum, arr))
            return true;
        return false;
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