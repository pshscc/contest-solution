
/**
 * @author JB Ladera
 */

import java.io.*;
import java.util.*;

public class Solution1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int g = sc.nextInt();
            int n = sc.nextInt();
            int[] arr = new int[(int) 1e6];
            while (n-- > 0) {
                int m = sc.nextInt();
                int s = sc.nextInt();
                int d = sc.nextInt();
                arr[s] += m;
                arr[s + d] -= m;
            }
            int max = arr[0];
            for (int x = 1; x < arr.length; x++) {
                arr[x] += arr[x - 1];
                max = Math.max(max, arr[x]);
            }
            if (max > g)
                System.out.println("OUT OF MEMORY: " + max + "KB REQUESTED");
            else
                System.out.println("SUFFICIENT");
        }
    }
}