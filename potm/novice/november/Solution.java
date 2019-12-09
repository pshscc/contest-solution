// Name: JB Ladera
// Novice Problem of the Month 1

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        Scanner in = new Scanner(System.in);

        // Rather than printing "off" or "on" every time we are given a number
        // we can append it to a StringBuilder and print that at the end.
        // this will reduce the number of calls we make to System.out.println.
        // Using System.out.println() is a heavy task and making A LOT of
        // calls will increase the runtime of a program.
        StringBuilder ans = new StringBuilder();
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            if (Math.sqrt(n) % 1 == 0)
                ans.append("on");
            else
                ans.append("off");
            ans.append('\n');
        }
        System.out.print(ans);

        long endTime = System.nanoTime();
        long diffTime = endTime - startTime;
        System.out.println(diffTime + " nanoseconds");
    }

}