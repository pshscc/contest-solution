import java.io.*;
import java.math.*;
import java.util.*;

public class Solution1 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new FileReader("pr51.dat"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        // StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(in.readLine());
        while (n-- > 0) {
            String s = in.readLine();
            String result = "";
            int x = 0;
            int i;
            for (i = s.length(); i >= 3; i -= 3) {
                if (i - 3 != 0) {
                    result = "," + s.substring(i - 3, i) + result;
                    x++;
                } else
                    result = s.substring(i - 3, i) + result;
            }
            if (i > 0)
                result = s.substring(0, i) + result;
            out.println(x + " " + result);
        }
        out.close();
    }
}