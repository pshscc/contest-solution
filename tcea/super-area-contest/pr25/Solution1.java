import java.io.*;
import java.math.*;
import java.util.*;

public class Solution1 {
    static Scanner sc, in;
    static PrintWriter out;

    public static void main(String[] args) throws Exception {
        sc = in = new Scanner(new File("pr25.dat"));
        out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = in.nextInt();
        in.nextLine();
        for (int i = 0; i < n; i++) {
            char[] s = in.nextLine().toCharArray();
            int ncount = 0;
            int ycount = 0;
            for (int j = 0; j < s.length; j++) {
                if (s[j] == 'N')
                    ncount++;
                else
                    ycount++;
            }
            if (ycount > ncount)
                out.println("ACCEPT");
            else
                out.println("REJECT");
        }

        out.close();
    }
}