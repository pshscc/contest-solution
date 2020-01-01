import java.io.*;
import java.math.*;
import java.util.*;

public class Solution1 {
    static Scanner sc, in;
    static PrintWriter out;

    public static void main(String[] args) throws Exception {
        sc = in = new Scanner(new File("pr22.dat"));
        out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            int a = in.nextInt();
            out.println(2 * a - 1);
        }

        out.close();
    }
}