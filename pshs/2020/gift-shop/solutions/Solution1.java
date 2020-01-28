
/**
 * @author JB Ladera
 */

import java.io.*;
import java.util.*;

public class Solution1 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] name = new String[n];
        double[] cost = new double[n];
        double min = 1e10, max = -1;
        for (int x = 0; x < n; x++) {
            name[x] = sc.next();
            cost[x] = sc.nextDouble() * sc.nextInt();
            max = Math.max(max, cost[x]);
            min = Math.min(min, cost[x]);
        }
        for (int x = 0; x < n; x++)
            if (cost[x] == max)
                System.out.print(name[x] + " ");
        System.out.println();
        for (int x = 0; x < n; x++)
            if (cost[x] == min)
                System.out.print(name[x] + " ");
    }
}