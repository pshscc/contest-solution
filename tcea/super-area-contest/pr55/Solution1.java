import java.io.*;
import java.math.*;
import java.util.*;

public class Solution1 {
    static Scanner sc, in;
    static PrintWriter out;

    public static void main(String[] args) throws Exception {
        sc = in = new Scanner(new File("pr55.dat"));
        out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        char[] user = { 'u', 'g', 'o' };
        String[] per = { "", "x", "w", "wx", "r", "rx", "rw", "rwx" };

        int n = sc.nextInt();
        while (n-- > 0) {
            char[] arr = sc.next().toCharArray();
            String want = sc.next();
            String res = "";
            for (int a = 0; a < arr.length; a++) {
                int x = arr[a] - '0';
                String can = per[x];
                boolean b = has(can, want);
                if (b)
                    res += user[a];
            }
            if (res.length() == 0)
                res = "n";
            out.println(res);
        }

        out.close();
    }

    static boolean has(String can, String want) {
        for (char c : want.toCharArray())
            if (can.indexOf(c) == -1)
                return false;
        return true;
    }
}