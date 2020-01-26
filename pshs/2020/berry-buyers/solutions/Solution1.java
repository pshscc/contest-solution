
/**
 * @author Shakeel Samsudeen
 */

import java.io.*;
import java.util.*;
import java.math.*;

public class Solution1 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        long m = Long.parseLong(st.nextToken());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long[] berry = new long[n];
        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < n; i++)
            berry[i] = Long.parseLong(st.nextToken());
        Arrays.sort(berry);
        long currDay = 1;
        long currStreak = 0;
        BigInteger profit = BigInteger.valueOf(m);
        int i = 1;
        while (i < n) {
            if (berry[i] == currDay) {
                profit = profit.add(BigInteger.valueOf(m + (currStreak > 0 ? a * currStreak + b : 0)));
            } else {
                currDay++;
                currStreak++;
                profit = profit.add(BigInteger.valueOf(m + (currStreak > 0 ? a * currStreak + b : 0)));
            }
            i++;
        }
        out.println(profit);
        out.close();
    }
}