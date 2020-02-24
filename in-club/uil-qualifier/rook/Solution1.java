
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
            int R = sc.nextInt();
            int C = sc.nextInt();
            int K = sc.nextInt();
            boolean[][] arr = new boolean[R][C];
            for (int x = 0; x < K; x++) {
                int r = sc.nextInt();
                int c = sc.nextInt();
                for (int a = 0; a < C; a++)
                    arr[r][a] = true;
                for (int a = 0; a < R; a++)
                    arr[a][c] = true;
            }
            int count = 0;
            for (boolean[] r : arr)
                for (boolean c : r)
                    if (!c)
                        count++;
            out.println(count);
        }

        out.close();
    }
}