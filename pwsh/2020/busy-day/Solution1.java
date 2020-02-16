
/**
 * @author Travis Dula
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
        int m = in.nextInt();
        double dtStart = in.nextDouble(), dtEnd = in.nextDouble();
        double[] e = new double[m];
        for (int i = 0; i < m; i++)
            e[i] = in.nextDouble();
        if (recur(dtStart, 24 - dtEnd, e, 0))
            out.print("YES");
        else
            out.print("NO");
        out.close();
    }

    public static boolean recur(double tStart, double tEnd, double[] e, int i) {
        if (i >= e.length)
            return true;
        boolean a = false, b = false;
        if (tStart - e[i] >= 0)
            a = recur(tStart - e[i], tEnd, e, i + 1);
        if (a)
            return true;
        if (tEnd - e[i] >= 0)
            b = recur(tStart, tEnd - e[i], e, i + 1);
        if (b)
            return true;
        return false;
    }
}