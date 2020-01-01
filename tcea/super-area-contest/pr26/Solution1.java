import java.io.*;
import java.math.*;
import java.util.*;

public class Solution1 {
    static Scanner sc, in;
    static PrintWriter out;

    public static void main(String[] args) throws Exception {
        sc = in = new Scanner(new File("pr26.dat"));
        out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            int x1 = in.nextInt();
            int y1 = in.nextInt();
            int x2 = in.nextInt();
            int y2 = in.nextInt();
            if (Math.abs((y2 - y1) / (x2 - x1)) >= 1)
                out.println("VERTICAL");
            else
                out.println("HORIZONTAL");
        }

        out.close();
    }
}