
/**
 * @author JB Ladera
 */

import java.io.*;
import java.util.*;

public class Solution3 {
    static Scanner sc, in;
    static PrintWriter out;

    public static void main(String[] args) throws Exception {
        sc = in = new Scanner(System.in);
        out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        Pancake[] pancakes = new Pancake[m];

        for (int x = 0; x < m; x++) {
            String t = sc.next();
            double p = sc.nextDouble();
            int q = sc.nextInt();
            pancakes[x] = new Pancake(t, p, q);
        }
        Arrays.sort(pancakes);

        double loss = 0;
        double[] arr = new double[n + 1];
        while (k-- > 0) {
            int c = sc.nextInt();
            String t = sc.next();
            Pancake temp = new Pancake(t, 0, 0);
            int x = Arrays.binarySearch(pancakes, temp);
            if (pancakes[x].q > 0) {
                pancakes[x].q--;
                arr[c] += pancakes[x].p;
            } else {
                loss += pancakes[x].p;
            }
        }

        for (int x = 1; x < arr.length; x++)
            out.printf("%.2f ", arr[x]);
        out.printf("\nTotal Loss: %.2f", loss);

        out.close();
    }

    static class Pancake implements Comparable<Pancake> {
        String t;
        double p;
        int q;

        public Pancake(String t, double p, int q) {
            this.t = t;
            this.p = p;
            this.q = q;
        }

        public int compareTo(Pancake o) {
            return t.compareTo(o.t);
        }
    }
}