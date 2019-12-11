/*
Solution by Shakeel Samsudeen
Time complexity: O(nlog(n) + n) = O(nlog(n))
Sorting takes O(nlog(n)) and simulation takes O(n) so this
simplifies to O(nlog(n)).
*/

import java.io.*;
import java.util.*;
import java.math.*;

public class Solution2 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        long m = Long.parseLong(st.nextToken());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long[] fish = new long[n];
        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < n; i++)
            fish[i] = Long.parseLong(st.nextToken());
        Arrays.sort(fish);
        long currDay = 1;
        long currStreak = 0;
        BigInteger profit = BigInteger.valueOf(m);
        int i = 1;
        while (i < n) {
            if (fish[i] == currDay) {
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