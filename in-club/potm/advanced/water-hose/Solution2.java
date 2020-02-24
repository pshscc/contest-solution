/*
Solution by Shakeel Samsudeen
Time complexity: O(nlog(n))
Note: This only runs in time because of BufferedReader.
If it was switched to Scanner, this would get TLE.
*/

import java.io.*;
import java.util.*;

public class Solution2 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int n = Integer.parseInt(in.readLine());
        TreeMap<Integer, Long> changes = new TreeMap<Integer, Long>();
        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int t = Integer.parseInt(st.nextToken());
            long q = Long.parseLong(st.nextToken());
            changes.put(t, q);
        }
        int q = Integer.parseInt(in.readLine());
        long[] currRate = new long[1000001];
        for (int i = currRate.length - 1; i >= 0; i--) {
            int key;
            if (changes.lowerKey(i) == null)
                key = -1;
            else
                key = changes.lowerKey(i);
            currRate[i] = key < 0 ? 0 : changes.get(key);
        }
        long[] prefix = new long[1000001];
        for (int i = 1; i < prefix.length; i++) {
            prefix[i] = prefix[i - 1] + currRate[i];
        }
        while (q-- > 0) {
            out.println(prefix[Integer.parseInt(in.readLine())]);
        }
        out.close();
    }
}