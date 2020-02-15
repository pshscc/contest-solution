
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
        int m = sc.nextInt() - 1;
        int[] arr = new int[n];
        for (int x = 0; x < n; x++)
            arr[x] = sc.nextInt();
        int max = (int) 1e5;
        int pos = m;
        for (int x = 0; x < max; x++) {
            pos += arr[pos];
            pos %= n;
            if (pos == m) {
                out.println("YES");
                out.close();
                return;
            }
        }
        out.println("NO");
        out.close();
    }
}