import java.util.*;
import java.io.*;

/* 
This is similar to Solution1 but uses indexOf() each line
to find the column of 'X' and '*'. Because we use indexOf(),
we do not to store the # of columns they give us in the input,
so we can skip it.
*/
public class Solution2 {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        for (int tc = 0; tc < n; tc++) {
            int row = in.nextInt();
            in.nextLine();
            int rStart = 0, cStart = 0, rX = 0, cX = 0;
            for (int r = 0; r < row; r++) {
                String line = in.nextLine();
                int c = line.indexOf('X');
                if (c > 0) {
                    cX = c;
                    rX = r;
                }
                c = line.indexOf('*');
                if (c > 0) {
                    cStart = c;
                    rStart = r;
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