
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
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            BigInteger[] arr = new BigInteger[n];
            for (int x = 0; x < n; x++)
                arr[x] = sc.nextBigInteger();
            BigInteger mul = arr[0];
            for (int x = 1; x < n; x++)
                mul = mul.multiply(arr[x]).divide(mul.gcd(arr[x]));
            out.println(mul);
        }

        out.close();
    }
}