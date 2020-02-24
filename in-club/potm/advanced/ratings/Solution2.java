
/**
 * @author Shakeel Samsudeen
 */

import java.io.*;
import java.util.*;

public class Solution2 {
    public static void main(String args[]) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        double total = 0;
        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < N; i++)
            total += Integer.parseInt(st.nextToken());
        int add = 0;
        int num = N;
        while (total / num < M) {
            total += 10;
            num++;
            add++;
        }
        out.println(add);
        out.close();
    }
}