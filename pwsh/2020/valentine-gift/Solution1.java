
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
        int min = Math.min(sc.nextInt() / 1, Math.min(sc.nextInt() / 2, sc.nextInt() / 4));
        out.println(min);
        out.close();
    }
}