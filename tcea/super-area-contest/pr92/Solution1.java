import java.io.*;
import java.math.*;
import java.util.*;

public class Solution1 {
    static Scanner sc, in;
    static PrintWriter out;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        sc = in = new Scanner(new File("pr92.dat"));
        out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        arr = new int[1000];
        arr['I'] = 1;
        arr['V'] = 5;
        arr['X'] = 10;
        arr['L'] = 50;
        arr['C'] = 100;
        arr['D'] = 500;
        arr['M'] = 1000;

        int n = sc.nextInt();
        while (n-- > 0) {
            String a = sc.next();
            String[] line = sc.nextLine().trim().split(" ");
            String op = line[0];
            String b = line[line.length - 1];
            int vala = parse(a);
            int valb = parse(b);
            if (op.equals("plus"))
                out.println(vala + valb);
            else if (op.equals("minus"))
                out.println(vala - valb);
            else if (op.equals("times"))
                out.println(vala * valb);
            else
                out.println(vala / valb);
        }

        out.close();
    }

    static int parse(String s) {
        int sum = 0;
        int prev = 0;
        for (int x = s.length() - 1; x >= 0; x--) {
            int val = arr[s.charAt(x)];
            if (val < prev)
                sum -= val;
            else
                sum += val;
            prev = val;
        }
        return sum;
    }
}