import java.io.*;
import java.util.*;

public class Solution1 {
    static Scanner sc, in;
    static PrintWriter out;

    public static void main(String[] args) throws Exception {
        sc = in = new Scanner(System.in);
        out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        ArrayList<A> arr = new ArrayList<>();
        while (sc.hasNextLine()) {
            String[] line = sc.nextLine().split(",");
            int d = Integer.parseInt(line[2].substring(1));
            arr.add(new A(line[0], line[1], d));
        }
        arr.sort(null);
        for (A a : arr)
            out.println(a);
        out.close();
    }

    static class A implements Comparable<A> {
        String color, style;
        int sides;

        public A(String a, String b, int s) {
            color = a;
            style = b;
            sides = s;
        }

        public int compareTo(A other) {
            if (sides == other.sides) {
                if (color.equals(other.color))
                    return style.compareTo(other.style);
                return color.compareTo(other.color);
            }
            return sides - other.sides;
        }

        public String toString() {
            return String.format("d%d (%s - %s)", sides, color, style);
        }
    }
}