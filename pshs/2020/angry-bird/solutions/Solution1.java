
/**
 * @author Shakeel Samsudeen
 */

import java.io.*;
import java.util.*;

public class Solution1 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(in.readLine());
        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            double h = Double.parseDouble(st.nextToken());
            double k = Double.parseDouble(st.nextToken());
            double x = Double.parseDouble(st.nextToken());
            double m = Double.parseDouble(st.nextToken());
            double theta = Double.parseDouble(st.nextToken());
            double d = Double.parseDouble(st.nextToken());
            double v = Math.sqrt((k * x * x) / m);
            double t1 = (v * Math.sin(Math.toRadians(theta))) / 9.8;
            double y = v * Math.sin(Math.toRadians(theta)) * t1 + 0.5 * -9.8 * t1 * t1;
            double t2 = Math.sqrt(2 * (h + y) / 9.8);
            double dist = v * Math.cos(Math.toRadians(theta)) * (t1 + t2);
            out.println(String.format("%.2f", Math.abs(dist - d)));
        }
        out.close();
    }
}