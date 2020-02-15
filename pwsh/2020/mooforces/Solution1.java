
/**
 * @author Travis Dula
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
        int n = in.nextInt();
        int m = in.nextInt();
        ArrayList<Contestant> list = new ArrayList<Contestant>();
        for (int i = 0; i < n; i++)
            list.add(new Contestant(in.next(), in.nextInt(), in.nextInt(), in.nextInt()));
        Collections.sort(list);
        for (int j = 0; j < m; j++)
            out.println(list.get(j));
        out.close();
    }

}

class Contestant implements Comparable<Contestant> {
    String name;
    int score, incorrect, time;

    public Contestant(String n, int s, int i, int t) {
        name = n;
        score = s;
        incorrect = i;
        time = t;
    }

    public int compareTo(Contestant c) {
        if (score - c.score == 0) {
            if (incorrect - c.incorrect == 0) {
                if (time - c.time == 0)
                    return name.compareTo(c.name);
                return time - c.time;
            } else
                return incorrect - c.incorrect;
        } else
            return c.score - this.score;
    }

    public String toString() {
        return name;
    }
}