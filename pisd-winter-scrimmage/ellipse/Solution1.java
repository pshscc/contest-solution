import java.io.*;
import java.util.*;

public class Solution1 {
    static Scanner sc, in;
    static PrintWriter out;

    public static void main(String[] args) throws Exception {
        sc = in = new Scanner(System.in);
        out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        while (in.hasNextDouble()) {
            double a = in.nextDouble();
            double b = in.nextDouble();
            double area = Math.PI * a * b;
            double perimeter = 2 * Math.PI * Math.sqrt((a * a + b * b) / 2);
            out.println(String.format("(area - %.3f) (perimeter - %.3f)", area, perimeter));
        }
        out.close();
    }
}