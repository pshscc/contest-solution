
/**
 * @author JB Ladera
 * Solution based off Kadane's algorithm
 * Overall time complexity: O(TN)
 */

import java.io.*;
import java.util.*;
import java.math.*;

public class Solution2 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            int[] arr = new int[N - 1];
            for (int x = 0; x < N - 1; x++)
                arr[x] = sc.nextInt();
            Segment best = new Segment(-1, -1, -1);
            int start = 0;
            int beauty = 0;
            for (int x = 0; x < arr.length; x++) {
                beauty += arr[x];
                // if beauty becomes negative, reset it to 0 and
                // the start index to the next index because if
                // you include the current value that made it negative,
                // beauty will never be maximized
                if (beauty < 0) {
                    beauty = 0;
                    start = x + 1;
                } else {
                    // check every possible segment and its value and choose best
                    Segment cur = new Segment(start, x, beauty);
                    if (cur.compareTo(best) < 0)
                        best = cur;
                }
            }
            if (best.b <= 0)
                System.out.println("Trip " + t + " is not beautiful");
            else
                System.out.printf("For trip %d, bike between stations %d and %d\n", t, best.s + 1, best.e + 2);
        }
    }

    // a class wasn't necessary to solve this problem, but sometimes
    // makes the code a bit cleaner/easier to read
    static class Segment implements Comparable<Segment> {
        int s, e, b; // start, end, beauty of segment

        public Segment(int s, int e, int v) {
            this.s = s;
            this.e = e;
            this.b = v;
        }

        public int compareTo(Segment o) {
            if (b == o.b) {
                int len1 = e - s + 1; // length of segment for current object
                int len2 = o.e - o.s + 1; // length of segment for object o
                if (len1 == len2)
                    return s - o.s; // if same length, choose smallest starting index
                return len2 - len1; // choose biggest length
            }
            // if object o has greater beauty, returns a number > 0,
            // else if current object has greater beauty, returns a number < 0
            return o.b - b;
        }
    }
}