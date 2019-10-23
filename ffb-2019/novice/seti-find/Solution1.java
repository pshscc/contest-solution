import java.io.*;
import java.util.*;

public class Solution1 {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        in.nextLine();
        while (T-- > 0) {
            char[] letters = in.nextLine().toCharArray();
            String ans = "";
            int i = 0;
            while (i < letters.length) {
                char cur = letters[i];
                i++;
                boolean match = false;
                while (i < letters.length && letters[i] == cur) {
                    match = true;
                    i++;
                }
                if (match)
                    ans += cur;
            }
            if (ans.length() == 0)
                System.out.println("0 -");
            else
                System.out.println(ans.length() + " " + ans);
        }
    }
}