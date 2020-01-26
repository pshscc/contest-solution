
/**
 * @author JB Ladera
 */

import java.io.*;
import java.util.*;

public class Solution3 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int p = sc.nextInt();
        if (p == 100) {
            System.out.println("impossible");
            return;
        }
        int t = 0;
        for (int x = 0; x < n; x++)
            t += sc.nextInt();
        System.out.println((int) Math.ceil((n * p - t) / (100d - p)));
    }
}