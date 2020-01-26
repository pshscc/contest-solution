
/**
 * @author JB Ladera
 */

import java.util.*;
import java.io.*;

public class Solution1 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int MAXT = (int) 1e6;
        long[] rate = new long[MAXT + 1];
        Arrays.fill(rate, 1, rate.length, -1);
        int n = sc.nextInt();
        int q = sc.nextInt();
        while (n-- > 0)
            rate[sc.nextInt()] = sc.nextLong();
        for (int x = 1; x < rate.length; x++)
            if (rate[x] == -1)
                rate[x] = rate[x - 1];
        long[] volume = new long[MAXT + 1];
        for (int x = 1; x < volume.length; x++)
            volume[x] = volume[x - 1] + rate[x - 1];
        while (q-- > 0)
            System.out.println(volume[sc.nextInt()]);
    }
}