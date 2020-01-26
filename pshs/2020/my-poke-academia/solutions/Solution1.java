
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
        ArrayList<Integer> scores = new ArrayList<Integer>();
        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < n; i++)
            scores.add(Integer.parseInt(st.nextToken()));
        if (p == 100)
            out.println("impossible");
        else {
            double total = 0;
            for (int i = 0; i < scores.size(); i++) {
                total += scores.get(i);
            }
            int add = 0;
            while (total / scores.size() < p) {
                total += 100;
                scores.add(100);
                add++;
            }
            out.println(add);
        }
        out.close();
    }
}