import java.util.*;
import java.io.*;

public class Solution1 {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (r % 2 == 0 && c % 2 == 0 || r % 2 == 1 && c % 2 == 1)
                    System.out.print("1 ");
                else
                    System.out.print("0 ");
            }
            System.out.println();
        }
    }
}