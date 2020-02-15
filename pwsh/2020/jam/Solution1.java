
/**
 * @author JB Ladera
 */

import java.io.*;
import java.util.*;
import java.math.*;

public class Solution1 {
    static Scanner sc, in;
    static PrintWriter out;

    public static void main(String[] args) throws Exception {
        sc = in = new Scanner(System.in);
        out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int H = sc.nextInt();
        int W = sc.nextInt();
        int h = sc.nextInt();
        int v = sc.nextInt();
        int[] horizontal = new int[h + 2];
        horizontal[0] = 0;
        horizontal[horizontal.length - 1] = H;
        int[] vertical = new int[v + 2];
        vertical[0] = 0;
        vertical[vertical.length - 1] = W;
        for (int x = 1; x <= h; x++)
            horizontal[x] = sc.nextInt();
        for (int x = 1; x <= v; x++)
            vertical[x] = sc.nextInt();
        ArrayList<Integer> widths = new ArrayList<>();
        ArrayList<Integer> heights = new ArrayList<>();
        for (int x = 1; x < horizontal.length; x++) {
            int height = horizontal[x] - horizontal[x - 1];
            heights.add(height);
        }
        for (int x = 1; x < vertical.length; x++) {
            int width = vertical[x] - vertical[x - 1];
            widths.add(width);
        }
        int area = 0;
        for (int x = 0; x < heights.size(); x++)
            for (int a = 0; a < widths.size(); a++)
                if (x % 2 == a % 2)
                    area += heights.get(x) * widths.get(a);
        out.println(area);
        out.close();
    }
}