import java.io.*;
import java.math.*;
import java.util.*;

public class Solution1 {
    static Scanner sc, in;
    static PrintWriter out;

    public static void main(String[] args) throws Exception {
        sc = in = new Scanner(new File("pr24.dat"));
        out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = in.nextInt();
        in.nextLine();
        for (int i = 0; i < n; i++) {
            String s = in.nextLine();
            if (s.substring(0, 2).equals("re")) {
                out.println(s.substring(2) + " once more");
            } else
                out.println(s);
        }

        out.close();
    }
}