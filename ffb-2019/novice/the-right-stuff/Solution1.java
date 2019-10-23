import java.util.*;
import java.io.*;

public class Solution1 {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        while (T-- > 0) {
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();
            if (a > b + c) {
                System.out.printf("Candidate %d with a score of %d has the Right Stuff!\n", 1, a);
            } else if (b > a + c) {
                System.out.printf("Candidate %d with a score of %d has the Right Stuff!\n", 2, b);
            } else if (c > a + b) {
                System.out.printf("Candidate %d with a score of %d has the Right Stuff!\n", 3, c);
            } else {
                System.out.println("No dominant candidate");
            }
        }
    }
}