
/**
 * @author Jonathan Tung
 */

import java.io.*;
import java.util.*;
import java.math.*;

public class TowerElevators {
    static Scanner sc, in;
    static PrintWriter out;

    public static void main(String[] args) throws Exception {
        sc = in = new Scanner(System.in);
        out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = in.nextInt(), m = in.nextInt();
        int[] floors = new int[n + 1];
        boolean possible = true;
        for (int i = 1; i <= m; i++) {
            int x = in.nextInt(), y = in.nextInt();
            for (int j = x; j <= y; j++) {
                floors[j]++;
                if (floors[j] >= 3) {
                    possible = false;
                    break;
                }
            }
        }
        if (possible)
            out.print("YES");
        else
            out.print("NO");
        out.close();
    }
}
