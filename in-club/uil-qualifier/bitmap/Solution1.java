
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

        int R = sc.nextInt();
        int C = sc.nextInt();
        int[][] map = new int[R + 1][C + 1];
        int[][] sum = new int[R + 1][C + 1];
        for (int r = 1; r <= R; r++) {
            String line = sc.next();
            for (int c = 1; c <= C; c++) {
                map[r][c] = line.charAt(c - 1) - '0';
            }
        }
        for (int r = 1; r <= R; r++) {
            for (int c = 1; c <= C; c++) {
                sum[r][c] = map[r][c];
                if (r > 0)
                    sum[r][c] += sum[r - 1][c];
                if (c > 0)
                    sum[r][c] += sum[r][c - 1];
                if (r > 0 && c > 0)
                    sum[r][c] -= sum[r - 1][c - 1];
            }
        }
        int area = 0;
        for (int r = 1; r <= R; r++)
            for (int c = 1; c <= C; c++) {
                for (int r1 = r; r1 <= R; r1++) {
                    for (int c1 = c; c1 <= C; c1++) {
                        int l = r1 - r + 1;
                        int w = c1 - c + 1;
                        if (l * w == sum[r1][c1] - sum[r1][c - 1] - sum[r - 1][c1] + sum[r - 1][c - 1]
                                && l * w > area) {
                            area = l * w;
                        }
                    }
                }
            }
        out.println(area);

        out.close();
    }
}