import java.io.*;
import java.util.*;

public class Solution1 {
    static Scanner sc, in;
    static PrintWriter out;

    public static void main(String[] args) throws Exception {
        sc = in = new Scanner(System.in);
        out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        sc.useDelimiter("[(),/\\s]+");
        double x1 = Double.parseDouble(sc.next());
        double y1 = Double.parseDouble(sc.next());
        double x2 = x1;
        double y2 = y1;
        while (sc.hasNext()) {
            double deg = Math.toRadians(Double.parseDouble(sc.next()));
            double dist = Double.parseDouble(sc.next());
            x2 += Math.cos(deg) * dist;
            y2 += Math.sin(deg) * dist;
        }
        double distance = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
        out.printf("%.2f", distance);
        out.close();
    }
}