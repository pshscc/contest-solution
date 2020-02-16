
/**
 * @author JB Ladera
 */

import java.io.*;
import java.util.*;
import java.math.*;

public class Solution {
    static Scanner sc, in;
    static PrintWriter out;

    static char[] arr;
    static int[] cur;

    public static void main(String[] args) throws Exception {
        sc = in = new Scanner(System.in);
        out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        arr = sc.next().toCharArray();
        cur = new int[arr.length];
        int max = -1;
        for (int x = 0; x < arr.length; x++) {
            int nochange = 0;
            if (x > 0 && arr[x] == arr[x - 1])
                nochange = cur[x - 1];
            else
                nochange = count(x);
            int change = 0;
            arr[x] = arr[x] == '<' ? '>' : '<';
            change = count(x);
            arr[x] = arr[x] == '<' ? '>' : '<';
            cur[x] = nochange;
            max = Math.max(max, Math.max(nochange, change));
        }
        out.println(max);
        out.close();
    }

    static int count(int x) {
        int a = 0;
        for (int q = x; q >= 0 && arr[q] == arr[x]; q--)
            a++;
        for (int q = x + 1; q < arr.length && arr[q] == arr[x]; q++)
            a++;
        return a;
    }
}