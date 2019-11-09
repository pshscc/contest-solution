import java.io.*;
import java.util.*;
import java.math.*;

public class Solution1 {
    static Scanner sc, in;
    static int MAXT = 1439;

    public static void main(String[] args) throws Exception {
        sc = in = new Scanner(System.in);
        int n = sc.nextInt();
        int[] start = new int[n];
        int[] end = new int[n];
        for (int x = 0; x < n; x++) {
            String s = sc.next();
            String[] part = s.split(":");
            int st = Integer.parseInt(part[0]) * 60 + parse(part[1]);
            start[x] = st;
        }
        for (int x = 0; x < n; x++) {
            String s = sc.next();
            String[] part = s.split(":");
            int st = Integer.parseInt(part[0]) * 60 + parse(part[1]);
            end[x] = st;
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int[] time = new int[MAXT + 1];
        for (int x = 0; x < n; x++) {
            time[start[x]]++;
            time[end[x]]--;
        }
        for (int x = 1; x < time.length; x++)
            time[x] += time[x - 1];
        int count = 0;
        for (int x = 0; x < time.length; x++)
            if (time[x] > 0)
                count++;
        System.out.println(count);
    }

    static int parse(String s) {
        if (s.charAt(0) == '0')
            return s.charAt(1) - '0';
        return Integer.parseInt(s);
    }
}