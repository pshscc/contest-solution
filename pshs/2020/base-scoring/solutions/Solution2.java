
/**
 * @author Jonothan Tung
 */

import java.io.*;
import java.util.*;

public class Solution2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int max = -1;
        int winner = 0;
        for (int i = 0; i < N; i++) {
            int score = digitSum(toOctal(in.nextInt())) + digitSum(toOctal(in.nextInt()))
                    + digitSum(toOctal(in.nextInt()));
            if (score > max) {
                max = score;
                winner = i + 1;
            }
        }
        System.out.println(winner);
    }

    public static int toOctal(int d) {
        String answer = "";
        do {
            answer = d % 8 + answer;
            d /= 8;
        } while (d > 0);
        return Integer.parseInt(answer);
    }

    public static int digitSum(int x) {
        int answer = 0;
        while (x > 0) {
            answer += x % 10;
            x /= 10;
        }
        return answer;
    }
}