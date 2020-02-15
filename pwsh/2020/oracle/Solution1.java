
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
        int a = 0;
        while (sc.hasNext()) {
            String word = sc.next();
            if (word.equals("not"))
                a++;
        }
        out.println(a % 2 == 0 ? "LOVE" : "SAD");
        out.close();
    }
}
