
/**
 * @author JB Ladera
 */

import java.util.Scanner;

public class Solution1 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int max = -1;
        int winner = 0;
        for (int x = 0; x < n; x++) {
            int sum = 0;
            for (int i = 0; i < 3; i++) {
                int num = sc.nextInt();
                while (num > 0) {
                    int d = num % 8;
                    num = (num - d) / 8;
                    sum += d;
                }
            }
            if (sum > max) {
                max = sum;
                winner = x;
            }
        }
        System.out.println(winner + 1);
    }
}