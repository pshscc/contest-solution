
/**
 * @author JB Ladera
 */

import java.io.*;
import java.util.*;

public class Solution2 {
    static Scanner sc, in;
    static PrintWriter out;

    static int MAXN = (int) 1e4;
    static int L, N;
    static Pair[] A = new Pair[MAXN + 1];

    public static void main(String[] args) throws Exception {
        sc = in = new Scanner(System.in);
        out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        for (;;) {
            L = sc.nextInt();
            N = sc.nextInt();
            if ((L | N) == 0) // same as doing L == 0 && N == 0
                break;
            for (int x = 0; x < N; x++) {
                int X = sc.nextInt();
                int R = sc.nextInt();
                A[x] = new Pair(X - R, X + R);
            }
            Arrays.sort(A, 0, N);
            solve();
        }
        out.close();
    }

    static void solve() {
        int x = getBestIndex(0, 0);
        int count = 0;
        while (x < N && x >= 0) {
            count++;
            if (A[x].e >= L) {
                out.println(N - count);
                return;
            }
            x = getBestIndex(x + 1, A[x].e);
        }
        out.println(-1);
    }

    static int getBestIndex(int x, int e) {
        int bestIndex = x;
        while (x < N && A[x].s <= e) {
            if (A[x].e > A[bestIndex].e)
                bestIndex = x;
            x++;
        }
        if (bestIndex >= N || A[bestIndex].s > e)
            return -1;
        return bestIndex;
    }

    static class Pair implements Comparable<Pair> {
        int s, e;

        public Pair(int s, int e) {
            this.s = s;
            this.e = e;
        }

        public int compareTo(Pair o) {
            if (s == o.s)
                return o.e - e;
            return s - o.s;
        }
    }
}