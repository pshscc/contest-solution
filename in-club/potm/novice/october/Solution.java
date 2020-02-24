// Name: JB Ladera
// Novice Problem of the Month 1

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        Scanner in = new Scanner(System.in);

        int[] fib = new int[47];
        fib[1] = fib[2] = 1;
        for (int x = 3; x < fib.length; x++)
            fib[x] = fib[x - 1] + fib[x - 2];
        boolean[] composite = new boolean[16_000_000];
        int[] prime = new int[1_000_001];
        int index = 1;
        double MAX = Math.sqrt(Integer.MAX_VALUE);
        for (int i = 2; index < prime.length; i++) {
            if (!composite[i]) {
                prime[index++] = i;
                if (i < MAX)
                    for (int j = i * i; j < composite.length; j += i)
                        composite[j] = true;
            }
        }
        int t = in.nextInt();
        for (int tc = 1; tc <= t; tc++) {
            char c = in.next().charAt(0);
            int n = in.nextInt();
            System.out.print(tc + ": ");
            if (c == 'F')
                System.out.println(fib[n]);
            else
                System.out.println(prime[n]);
        }

        long endTime = System.nanoTime();
        long diffTime = endTime - startTime;
        System.out.println(diffTime + " nanoseconds");
    }
}