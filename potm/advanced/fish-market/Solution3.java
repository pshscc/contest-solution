/*
Solution by JB Ladera
Time complexity: O(2nlog(n)) = O(nlog(n))
If you simplify the time complexity, this runs in the same time
as Shakeel's solution, however in reality, this is solution is
slower due to the numerous amounts of method calls that take O(log(n)).
*/

import java.io.*;
import java.util.*;
import java.math.*;

public class Solution3 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int MAXD = (int) 1e7;
        long N = sc.nextInt(), M = sc.nextInt(), A = sc.nextInt(), B = sc.nextInt();
        long fishCost = N * M;
        long days = -1;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int x = 0; x < N; x++) {
            int d = sc.nextInt();
            map.put(d, map.containsKey(d) ? map.get(d) + 1 : 1);
        }
        for (int d = 0; d < MAXD;) {
            Map.Entry<Integer, Integer> spoil = map.higherEntry(d);
            if (spoil == null)
                break;
            int k = Math.min(spoil.getKey() - d, spoil.getValue());
            days += k;
            d += k;
            map.remove(spoil.getKey());
        }
        BigInteger part = BigInteger.valueOf(A + B + A * days + B);
        BigInteger sum = BigInteger.valueOf(days).multiply(part).divide(BigInteger.valueOf(2));
        BigInteger total = sum.add(BigInteger.valueOf(fishCost));
        System.out.println(total);
    }
}