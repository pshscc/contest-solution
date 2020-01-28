
/**
 * @author Shakeel Samsudeen
 */

import java.io.*;
import java.util.*;

public class Solution1 {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.readLine());
        while (n-- > 0) {
            double h = in.nextDouble();
            double k = in.nextDouble();
            double x = in.nextDouble();
            double m = in.nextDouble();
            double theta = in.nextDouble();
            double d = in.nextDouble();
            double v = Math.sqrt((k * x * x) / m);
            double t1 = (v * Math.sin(Math.toRadians(theta))) / 9.8;
            double y = v * Math.sin(Math.toRadians(theta)) * t1 + 0.5 * -9.8 * t1 * t1;
            double t2 = Math.sqrt(2 * (h + y) / 9.8);
            double dist = v * Math.cos(Math.toRadians(theta)) * (t1 + t2);
            System.out.println(String.format("%.2f", Math.abs(dist - d)));
        }
    }
}