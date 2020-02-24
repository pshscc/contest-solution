
/**
 * @author JB Ladera
 */

import java.io.*;
import java.util.*;

public class Solution1 {
    static Scanner sc, in;
    static PrintWriter out;

    public static void main(String[] args) throws Exception {
        sc = in = new Scanner(System.in);
        out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int n = sc.nextInt();
        while (n-- > 0) {
            int goal = sc.nextInt();
            sc.nextLine();
            String[] arr = sc.nextLine().split(" ");
            int[] num = new int[arr.length];
            for (int x = 0; x < num.length; x++)
                num[x] = Integer.parseInt(arr[x]);
            if (valid(0, goal, num))
                out.println("YES");
            else
                out.println("NO");
        }

        out.close();
    }

    static boolean valid(int x, int target, int[] arr) {
        if (target == 0)
            return true;
        if (x >= arr.length)
            return false;
        if (valid(x + 1, target - arr[x], arr))
            return true;
        if (valid(x + 1, target, arr))
            return true;
        return false;
    }
}