import java.util.*;
import java.io.*;

public class Solution1 {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        for (int tc = 0; tc < n; tc++) {
            int row = in.nextInt();
            int col = in.nextInt();
            in.nextLine();
            int rStart = 0, cStart = 0, rX = 0, cX = 0;
            for (int r = 0; r < row; r++) {
                String line = in.nextLine();
                for (int c = 0; c < col; c++) {
                    if (line.charAt(c) == 'X') {
                        cX = c;
                        rX = r;
                    } else if (line.charAt(c) == '*') {
                        cStart = c;
                        rStart = r;
                    }
                }
            }
            int rResult = rStart - rX;
            int cResult = cStart - cX;
            if (rResult > 0)
                System.out.print(rResult + " north ");
            else if (rResult < 0)
                System.out.print(-rResult + " south ");
            if (cResult > 0)
                System.out.print(cResult + " west");
            else if (cResult < 0)
                System.out.print(-cResult + " east");
            System.out.println();
        }
    }
}