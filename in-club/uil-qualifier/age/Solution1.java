
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
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - a;
            System.err.println("here: " + a + " " + b);
            int m = sc.nextInt();
            boolean found = false;
            for (int x = 1; x < 10000; x++, b++) {
                System.err.println(x + " " + b);
                if (x * m == b) {
                    out.println(x + " " + b);
                    found = true;
                    break;
                }
            }
            if (!found)
                out.println("NEVER");
        }

        out.close();
    }
}