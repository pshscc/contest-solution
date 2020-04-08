
/**
 * @author JB Ladera
 */

import java.io.*;
import java.util.*;

public class Solution2 {
    static Scanner sc, in;
    static PrintWriter out;

    public static void main(String[] args) throws Exception {
        sc = in = new Scanner(System.in);
        out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        HashMap<String, Double> price = new HashMap<>();
        HashMap<String, Integer> freq = new HashMap<>();
        while (m-- > 0) {
            String t = sc.next();
            double p = sc.nextDouble();
            int q = sc.nextInt();
            price.put(t, p);
            freq.put(t, q);
        }

        double loss = 0;
        double[] arr = new double[n + 1];
        while (k-- > 0) {
            int c = sc.nextInt();
            String t = sc.next();
            if (freq.get(t) > 0) {
                freq.put(t, freq.get(t) - 1);
                arr[c] += price.get(t);
            } else {
                loss += price.get(t);
            }
        }

        for (int x = 1; x < arr.length; x++)
            out.printf("%.2f ", arr[x]);
        out.printf("\nTotal Loss: %.2f", loss);

        out.close();
    }
}