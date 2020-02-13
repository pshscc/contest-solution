
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
            int n = sc.nextInt();
            sc.nextLine();
            Stack<String> pants = new Stack<>(), shirt = new Stack<>(), socks = new Stack<>();
            while (n-- > 0) {
                String line = sc.nextLine();
                int lastspace = line.lastIndexOf(" ");
                String name = line.substring(0, lastspace);
                String type = line.substring(lastspace + 1);
                if (type.equals("(shirt)"))
                    shirt.push(name);
                else if (type.equals("(pants)"))
                    pants.push(name);
                else
                    socks.push(name);
            }
            int size = Math.min(pants.size(), Math.min(shirt.size(), socks.size()));
            while (size-- > 0)
                out.println(shirt.pop() + ", " + pants.pop() + ", " + socks.pop());
            out.println();
        }
        out.close();
    }
}