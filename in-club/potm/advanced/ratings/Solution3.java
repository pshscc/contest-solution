
/**
 * @author JB Ladera
 */

import java.io.*;
import java.util.*;

public class Solution3 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int s = 0;
        for (int x = 0; x < n; x++)
            s += sc.nextInt();
        int ans = (int) Math.ceil((m * n - s) / (10d - m));
        System.out.println(ans);
    }
}