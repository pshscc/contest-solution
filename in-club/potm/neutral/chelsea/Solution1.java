
/**
 * @author Shakeel Samsudeen
 */

import java.io.*;
import java.util.*;

public class Solution1 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        String line = "";
        while ((line = in.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(line);
            int l = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            if (l == 0 && n == 0)
                break;
            ArrayList<State> states = new ArrayList<State>();
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(in.readLine());
                int x = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                states.add(new State(x, r));
            }
            Collections.sort(states);
            boolean possible = true;
            int currLeft = 0, s = 0;
            for (int i = 0; i < n && possible; i++) {
                if (currLeft >= l)
                    break;
                if (states.get(i).right < currLeft)
                    continue;
                if (states.get(i).left <= currLeft) {
                    int maxRight = -1;
                    int maxI = i;
                    for (int j = i; j < n && states.get(j).left <= currLeft; j++) {
                        if (states.get(j).right > maxRight) {
                            maxRight = states.get(j).right;
                            maxI = j;
                        }
                    }
                    s++;
                    currLeft = maxRight;
                    i = maxI;
                } else
                    possible = false;
            }
            if (possible)
                possible = currLeft >= l;
            out.println(possible ? n - s : -1);
        }
        out.close();
    }
}

class State implements Comparable<State> {
    int x;
    int left;
    int right;

    public State(int x, int r) {
        this.left = x - r;
        this.right = x + r;
    }

    public int compareTo(State s) {
        if (s.left == left)
            return s.right - right;
        return left - s.left;
    }

    public String toString() {
        return left + " " + right;
    }
}