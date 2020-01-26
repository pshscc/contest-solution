
/**
 * @author JB Ladera
 */

import java.util.Scanner;

public class Solution3 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int max = -1;
        int winner = 0;
        for (int x = 0; x < n; x++) {
            int sum = 0;
            for (int i = 0; i < 3; i++) {
                int num = sc.nextInt();
                String octal = Integer.toOctalString(num);
                for (int j = 0; j < octal.length(); j++)
                    sum += Integer.parseInt(octal.substring(j, j + 1));
            }
            if (sum > max) {
                max = sum;
                winner = x;
            }
        }
        System.out.println(winner + 1);
    }
}