
/**
 * @author Shakeel Samsudeen
 */

import java.io.*;
import java.util.*;

public class Solution1 {
    public static void main(String args[]) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        double total = 0;
        int amount = n;
        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < n; i++)
            total += Integer.parseInt(st.nextToken());
        if (p == 100)
            out.println("impossible");
        else {
            int add = 0;
            while (total / amount < p) {
                total += 100;
                add++;
                amount++;
            }
            out.println(add);
        }
        out.close();
    }
}