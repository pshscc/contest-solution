
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
        sc.nextLine();
        while (n-- > 0) {
            String line = sc.nextLine();
            if (line.endsWith("."))
                out.println(line);
            else
                out.println(line + ".");
        }
        out.close();
    }
}