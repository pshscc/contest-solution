import java.io.*;
import java.math.*;
import java.util.*;

public class Solution1 {
    static Scanner sc, in;
    static PrintWriter out;

    public static void main(String[] args) throws Exception {
        sc = in = new Scanner(new File("pr21.dat"));
        out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            int a = in.nextInt();
            if (a >= 50)
                out.println("KEEP GOING");
            else
                out.println("MUST GO FASTER");
        }

        out.close();
    }
}