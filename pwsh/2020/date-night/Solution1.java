
/**
 * @author Travis Dula
 */

import java.io.*;
import java.util.*;
import java.math.*;

public class Solution1 {
    static Scanner sc, in;
    static PrintWriter out;

    public static void main(String[] args) {
        sc = in = new Scanner(System.in);
        out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        double total = 1;
        double sum = 0;
        double[] nums = new double[10];
        for (int i = 0; i < 10; i++) {
            nums[i] = in.nextDouble();
            total *= nums[i];
            sum += nums[i];
        }
        out.printf("%.5f", total / sum);
        out.close();
    }
}