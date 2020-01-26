
/**
 * @author JB Ladera
 */

import java.util.Scanner;

public class Solution1 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int R = sc.nextInt();
        int C = sc.nextInt();
        int H = sc.nextInt();
        int V = sc.nextInt();
        int maxW = 0, maxL = 0;
        int prev = 0;
        while (H-- > 0) {
            int h = sc.nextInt();
            maxL = Math.max(maxL, h - prev);
            prev = h;
        }
        maxL = Math.max(maxL, R - prev);
        prev = 0;
        while (V-- > 0) {
            int v = sc.nextInt();
            maxW = Math.max(maxW, v - prev);
            prev = v;
        }
        maxW = Math.max(maxW, C - prev);
        System.out.println(maxW * maxL);
    }
}