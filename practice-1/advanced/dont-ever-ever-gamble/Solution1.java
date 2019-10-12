import java.util.*;
import java.io.*;

public class Solution1 {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int tc = 1;
        while (in.hasNextInt()) {
            int n = in.nextInt();
            int m = in.nextInt();
            int reps = Math.abs(n - m) + 1;
            int min = Math.min(n, m);
            System.out.println("Test Case " + tc + ":");
            for (int num = min + 1; num < reps + min + 1; num++)
                System.out.println(num);
            tc++;
        }
    }
}