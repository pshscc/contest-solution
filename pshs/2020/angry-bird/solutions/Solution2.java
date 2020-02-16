
/**
 * @author Jonathan Tung
 */

import java.io.*;
import java.util.*;

public class Solution2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        for (int i = 0; i < N; i++) {
            double h = in.nextInt();
            double k = in.nextInt();
            double x = in.nextInt();
            double m = in.nextInt();
            double theta = Math.toRadians(in.nextInt());
            double d = in.nextInt();
            double v = Math.sqrt((k * x * x) / m);
            double t = (v * Math.sin(theta) + Math.sqrt(Math.pow(v * Math.sin(theta), 2) + 19.6 * h)) / 9.8;
            System.out.printf("%.2f%n", Math.abs(d - v * Math.cos(theta) * t));
        }
    }
}