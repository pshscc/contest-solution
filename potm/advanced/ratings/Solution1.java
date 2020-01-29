
/**
 * @author JB Ladera
 */

import java.io.*;
import java.util.*;

public class Solution1 {
    public static void main(String[] args) throws Exception {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(sc.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int sum = 0;
        st = new StringTokenizer(sc.readLine());
        for (int x = 0; x < n; x++)
            sum += Integer.parseInt(st.nextToken());
        int lo = n + 1;
        int hi = (int) 1e8;
        int ans = 0;
        while (lo < hi) {
            int t = (lo + hi) >> 1;
            int add = t - n;
            double s = add * 10 + sum;
            if (s / t >= m) {
                ans = add;
                hi = t;
            } else {
                lo = t + 1;
            }
        }
        System.out.println(ans);
    }
}