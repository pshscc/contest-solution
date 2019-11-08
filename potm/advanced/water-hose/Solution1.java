/*
Solution by JB Ladera
Time complexity: O(n)
*/

import java.util.*;
import java.io.*;

public class Solution1 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int MAXT = (int) 1e6;
        long[] rate = new long[MAXT + 1];
        // we use -1 to indicate that R(t) is unknown
        Arrays.fill(rate, 1, rate.length, -1);
        int n = sc.nextInt();
        while (n-- > 0)
            rate[sc.nextInt()] = sc.nextLong();
        for (int x = 1; x < rate.length; x++)
            if (rate[x] == -1)
                rate[x] = rate[x - 1];
        long[] volume = new long[MAXT + 1];
        for (int x = 1; x < volume.length; x++)
            volume[x] = volume[x - 1] + rate[x - 1];
        int q = sc.nextInt();
        StringBuilder out = new StringBuilder();
        while (q-- > 0)
            out.append(volume[sc.nextInt()]).append('\n');
        System.out.print(out);
    }
}