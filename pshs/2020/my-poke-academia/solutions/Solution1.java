
/**
 * @author Shakeel Samsudeen
 */

import java.io.*;
import java.util.*;

public class Solution1 {
    public static void main(String args[]) throws Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int p = in.nextInt();
        double total = 0;
        int amount = n;
        for (int i = 0; i < n; i++)
            total += in.nextInt();
        if (p == 100)
            System.out.println("impossible");
        else {
            int add = 0;
            while (total / amount < p) {
                total += 100;
                add++;
                amount++;
            }
            System.out.println(add);
        }
    }
}