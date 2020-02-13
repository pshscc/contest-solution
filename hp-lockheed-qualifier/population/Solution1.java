
/**
 * @author Jeremy Zhang
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
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            int p = in.nextInt();
            int t = in.nextInt();
            out.println(p - (t / 7) + (t / 4));
        }
        out.close();
    }
}