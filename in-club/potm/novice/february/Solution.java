/**
 * @author Shakeel Samsudeen
 * We can use Kadane's Algorithm to solve this problem.
 * It'll scan the array for the maximum sum in O(n) time,
 * which is exactly what we want for this scenario.
 */

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int T = Integer.parseInt(in.readLine());
        for(int t = 1; t <= T; t++) {
            int s = Integer.parseInt(in.readLine());
            int[] arr = new int[s - 1];
            StringTokenizer st = new StringTokenizer(in.readLine());
            for(int i = 0; i < arr.length; i++) 
                arr[i] = Integer.parseInt(st.nextToken());
            // We're basically going to keep track of the overall maximum
            // and a temporary maximum; the temporary maximum ensures
            // that we locate the optimal subsequence, which is when
            // we subsequently update the overall maximum. We can also
            // keep track of the starting and ending indices of these 
            // subsequences, as needed by the problem
            int max = 0, maxTemp = 0;
            int start = 0, startTemp = 0, end = -1;
            for(int i = 0; i < arr.length; i++) {
                maxTemp += arr[i];
                if(maxTemp < 0) {
                    maxTemp = 0;
                    startTemp = i + 1;
                }
                if(max < maxTemp || (max == maxTemp && i + 1 - startTemp > end - start)) {
                    max = maxTemp;
                    start = startTemp;
                    end = i + 1;
                }
            }
            // Be aware that you cannot start at a station of 0; that was
            // an important caveat of this problem.
            if(max == 0)
                out.println("Trip " + t + " is not beautiful");
            else 
                out.println("For trip " + t + ", bike between stations " + (start + 1) + " and "  + (end + 1));
        }
        out.close();
    }
}