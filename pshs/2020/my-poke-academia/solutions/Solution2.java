
/**
 * @author JB Ladera
 */

import java.io.*;
import java.util.*;

public class Solution2 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int p = sc.nextInt();
        if (p == 100) {
            System.out.println("impossible");
            return;
        }
        int sum = 0;
        for (int x = 0; x < n; x++)
            sum += sc.nextInt();
        int lower = n + 1;
        int upper = (int) 1e6;
        int ans = 0;
        while (lower < upper) {
            int mid = (lower + upper) / 2;
            int add = mid - n;
            int total = add * 100 + sum;
            if (total / (double) mid >= p) {
                ans = add;
                upper = mid;
            } else {
                lower = mid + 1;
            }
        }
        System.out.println(ans);
    }
}