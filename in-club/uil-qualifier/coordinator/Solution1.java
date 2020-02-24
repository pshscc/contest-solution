
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
            int m = sc.nextInt();
            long[] size = new long[n];
            TreeMap<Long, Long> map = new TreeMap<>();
            for (int x = 0; x < n; x++)
                size[x] = sc.nextInt();
            for (int x = 0; x < m; x++) {
                long s = sc.nextInt();
                long e = sc.nextInt();
                int g = sc.nextInt();
                Long val = map.get(s);
                Long val2 = map.get(e);
                if (val == null)
                    val = 0L;
                if (val2 == null)
                    val2 = 0L;
                map.put(s, val + g);
                map.put(e, val2 - g);
            }
            Iterator<Long> it = map.keySet().iterator();
            long max = map.get(it.next());
            long val = max;
            while (it.hasNext()) {
                long key = it.next();
                val += map.get(key);
                max = Math.max(max, val);
            }
            boolean found = false;
            for (int x = 0; x < size.length; x++)
                if (size[x] >= max) {
                    out.println((char) (x + 'A'));
                    found = true;
                    break;
                }
            if (!found)
                out.println("Not Possible");
        }

        out.close();
    }
}