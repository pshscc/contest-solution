import java.io.*;
import java.util.*;

public class Solution1 {
    static Scanner sc, in;
    static PrintWriter out;

    public static void main(String[] args) throws Exception {
        sc = in = new Scanner(System.in);
        out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        while (in.hasNextLine()) {
            String original = in.nextLine();
            String result = "";
            for (int i = 0; i < original.length(); i++) {
                int sum1 = 0;
                int sum2 = 0;
                for (int x = i; x < i + 3 && x < original.length(); x++)
                    sum1 += original.charAt(x);
                for (int x = i; x > i - 3 && x >= 0; x--)
                    sum2 += original.charAt(x);
                boolean rule1 = sum1 >= 280;
                boolean rule2 = sum2 <= 180;
                char c = original.charAt(i);
                if (rule1 && rule2)
                    c--;
                else if (rule1)
                    c += 3;
                else if (rule2)
                    c -= 4;
                result += c;
            }
            out.println(result);
        }
        out.close();
    }
}