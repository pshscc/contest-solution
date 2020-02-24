import java.io.*;
import java.util.*;
import java.math.*;

public class Solution1 {
    static Scanner sc, in;
    static Set<Character> L, R;

    public static void main(String[] args) throws Exception {
        sc = in = new Scanner(System.in);
        String leftString = "qwertasdfgzxcvb";
        String rightString = "poiuylkjhmn";
        L = new HashSet<>();
        R = new HashSet<>();
        for (char c : leftString.toCharArray())
            L.add(c);
        for (char c : rightString.toCharArray())
            R.add(c);
        int N = sc.nextInt();
        while (N-- > 0) {
            String s = sc.next();
            boolean pong = isPong(s);
            System.out.println(s + " " + (pong ? "plays ping pong" : "does not play ping pong"));
        }
    }

    static boolean isPong(String s) {
        boolean left = false, right = false;
        for (int x = 0; x < s.length(); x += 2) {
            char c = s.charAt(x);
            left |= L.contains(c);
            right |= R.contains(c);
        }
        if (!(right ^ left))
            return false;
        for (int x = 1; x < s.length(); x += 2) {
            char c = s.charAt(x);
            if (left && !R.contains(c))
                return false;
            if (right && !L.contains(c))
                return false;
        }
        return true;
    }
}