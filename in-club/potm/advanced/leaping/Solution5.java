
/**
 * @author Travis Dula
 */

import java.io.*;
import java.util.*;

public class Solution5 {
    static BufferedReader in;
    static PrintWriter out;
    static StringTokenizer st;
    static int[][] days;

    public static void main(String[] args) throws Exception {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        days = new int[n][8];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < 8; j++) {
                days[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[] earnings = new int[n];
        for (int j = 0; j < n; j++) {
            int xMoves, yMoves;
            xMoves = magic(days[j][0], days[j][2], days[j][4], days[j][5]);
            yMoves = magic(days[j][1], days[j][3], days[j][6], days[j][7]);
            earnings[j] = Math.max(50 - (xMoves + yMoves), 0);
        }
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(in.readLine());
            int total = 0, start = Integer.parseInt(st.nextToken()), end = Integer.parseInt(st.nextToken());
            for (int j = start; j <= end; j++) {
                total += earnings[j - 1];
            }
            out.println(total);
        }
        out.close();
    }

    static int magic(int loc, int goal, int forward, int backward) {
        HashSet<Integer> visited = new HashSet<Integer>();
        Queue<Integer> queue = new ArrayDeque<Integer>();
        int curr;
        queue.add(loc);
        for (int i = 0; i < 50; i++) {
            int j = queue.size();
            while (j-- > 0) {
                curr = queue.poll();
                if (visited.contains(curr))
                    continue;
                visited.add(curr);
                if (curr == goal)
                    return i;
                if (!visited.contains(validate(curr - backward)))
                    queue.add(validate(curr - backward));
                if (!visited.contains(validate(curr + forward)))
                    queue.add(validate(curr + forward));
            }
        }
        return 50;
    }

    static int validate(int z) {
        return Math.min(Math.max(z, 1), 500);
    }
}