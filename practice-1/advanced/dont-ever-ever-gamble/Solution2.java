import java.util.*;
import java.io.*;

public class Solution2 {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int tc = 1;
        while (in.hasNextInt()) {
            int n = in.nextInt();
            int m = in.nextInt();
            int max = -1;
            Map<Integer, Integer> sumsCount = new TreeMap<>();
            for (int a = 1; a <= n; a++) {
                for (int b = 1; b <= m; b++) {
                    int sum = a + b;
                    if (!sumsCount.containsKey(sum))
                        sumsCount.put(sum, 0);
                    int count = sumsCount.get(sum) + 1;
                    max = Math.max(max, count);
                    sumsCount.put(sum, count);
                }
            }
            System.out.println("Test Case " + tc + ":");
            for (Map.Entry<Integer, Integer> pair : sumsCount.entrySet())
                if (pair.getValue() == max)
                    System.out.println(pair.getKey());
            tc++;
        }
    }
}