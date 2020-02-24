
/**
 * @author JB Ladera
 */

import java.io.*;
import java.util.*;
import java.math.*;

public class Solution2 {
    static Scanner sc, in;
    static PrintWriter out;

    public static void main(String[] args) throws Exception {
        sc = in = new Scanner(System.in);
        out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = sc.nextInt();
        while (t-- > 0) {
            int w = sc.nextInt();
            int m = sc.nextInt();
            sc.nextLine();
            ArrayList<String> words = new ArrayList<>();
            while (m-- > 0) {
                String[] line = sc.nextLine().split(" ");
                for (String s : line)
                    words.add(s);
            }
            while (!words.isEmpty()) {
                String str = words.remove(0);
                while (!words.isEmpty()) {
                    String word = " " + words.get(0);
                    if (str.length() + word.length() > w)
                        break;
                    str += word;
                    words.remove(0);
                }
                out.println(str);
            }
            out.println();
        }
        out.close();
    }
}