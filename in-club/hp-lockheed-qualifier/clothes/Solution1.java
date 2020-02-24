
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
            int n = sc.nextInt();
            sc.nextLine();
            Stack<String>[] arr = new Stack[3];
            for (int x = 0; x < 3; x++)
                arr[x] = new Stack<>();
            while (n-- > 0) {
                String line = sc.nextLine();
                String[] part = line.split(" \\(");
                String name = part[0];
                if (part[1].startsWith("shirt"))
                    arr[0].push(name);
                else if (part[1].startsWith("pants"))
                    arr[1].push(name);
                else
                    arr[2].push(name);
            }
            int size = Integer.MAX_VALUE;
            for (Stack<String> s : arr)
                size = Math.min(size, s.size());
            while (size-- > 0)
                out.println(arr[0].pop() + ", " + arr[1].pop() + ", " + arr[2].pop());
            out.println();
        }
        out.close();
    }
}