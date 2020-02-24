
/**
 * @author JB Ladera
 */

import java.io.*;
import java.util.*;
import java.math.*;

public class Solution1 {
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
            Queue<String> words = new LinkedList<>();
            while (m-- > 0) {
                String[] line = sc.nextLine().split(" ");
                for (String s : line)
                    words.add(s);
            }
            while (!words.isEmpty()) {
                // used stringbuilder for efficient string
                // concatenation although not really needed
                // because UIL does not usually have very
                // difficult test cases (important to know because
                // sometimes an inefficient solution can actually pass)
                StringBuilder str = new StringBuilder();
                str.append(words.poll());
                while (!words.isEmpty()) {
                    String word = " " + words.peek();
                    if (str.length() + word.length() > w)
                        break;
                    str.append(word);
                    words.poll();
                }
                out.println(str);
            }
            out.println();
        }
        out.close();
    }
}