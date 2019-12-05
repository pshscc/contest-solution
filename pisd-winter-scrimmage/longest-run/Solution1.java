import java.io.*;
import java.util.*;

public class Solution1 {
    static Scanner sc, in;
    static PrintWriter out;

    public static void main(String[] args) throws Exception {
        sc = in = new Scanner(System.in);
        out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        while (in.hasNextLine()) {
            String s = in.nextLine();
            String[] a = s.substring(1, s.indexOf(")")).split(",");
            String[] num2 = s.substring(s.indexOf(")") + 2).split(",");
            int[] nums = new int[a.length];
            int target = Integer.parseInt(num2[0]);
            int tol = Integer.parseInt(num2[1]);
            int low = target - tol;
            int high = target + tol;
            int count = 0;
            int maxCount = count;
            for (int i = 0; i < a.length; i++)
                nums[i] = Integer.parseInt(a[i]);
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] >= low && nums[i] <= high) {
                    count++;
                    if (count > maxCount)
                        maxCount = count;
                } else
                    count = 0;
            }
            if (count > 1)
                System.out.println("Run Length - " + maxCount);
            else
                System.out.println("No Run");
        }
        out.close();
    }
}