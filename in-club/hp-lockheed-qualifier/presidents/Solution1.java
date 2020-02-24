
/**
 * @author Jeremy Zhang
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
        int n = in.nextInt();
        in.nextLine();
        for (int i = 0; i < n; i++) {
            int count = 0;
            String[] words = in.nextLine().split(" ");
            for (String word : words) {
                if (word.equals("Franklin"))
                    count += 100;
                else if (word.equals("Grant"))
                    count += 50;
                else if (word.equals("Jackson"))
                    count += 20;
                else if (word.equals("Hamilton"))
                    count += 10;
                else if (word.equals("Lincoln"))
                    count += 5;
                else if (word.equals("Washington"))
                    count += 1;
            }
            out.println("$" + count);
        }
        out.close();
    }
}