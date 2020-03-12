
/**
 * @author JB Ladera
 * Brute force solution
 * Overall time complexity: O(TN^2)
 */

import java.io.*;
import java.util.*;
import java.math.*;

public class Solution4 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            int[] arr = new int[N - 1]; // prefix sum array
            for (int x = 0; x < N - 1; x++)
                arr[x] = sc.nextInt();
            for (int x = 1; x < N - 1; x++)
                arr[x] += arr[x - 1]; // build prefix sum array
            int sb = 0, eb = 0, best = Integer.MIN_VALUE;
            // check every possible segment's ([s, e]) beauty value
            for (int s = 0; s < N - 1; s++) {
                for (int e = s; e < N - 1; e++) {
                    int val;
                    if (s == 0)
                        val = arr[e];
                    else
                        val = arr[e] - arr[s - 1];
                    if (val > best) {
                        best = val;
                        sb = s;
                        eb = e;
                    } else if (val == best) {
                        int len1 = eb - sb + 1;
                        int len2 = e - s + 1;
                        if (len2 > len1) {
                            sb = s;
                            eb = e;
                        }
                    }
                }
            }
            if (best <= 0)
                System.out.println("Trip " + t + " is not beautiful");
            else
                System.out.println("For trip " + t + ", bike between stations " + (sb + 1) + " and " + (eb + 2));
        }
    }
}