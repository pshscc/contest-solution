import java.io.*;
import java.util.*;

public class Solution1 {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        while(in.hasNextInt()){
            int x1 = in.nextInt();
            int y1 = in.nextInt();
            int x2 = in.nextInt();
            int y2 = in.nextInt();
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();
            int d = in.nextInt();
            if(x1 + x2 + y1 + y2 + a + b + c + d == 0)
                break;
            else{
                double slope = (d-b)/(double)(c-a);
                int dist = x2-x1;
                System.out.println((int)Math.round(Math.sqrt(Math.pow(dist,2)+Math.pow(dist*slope,2))));
            }
        }
    }
}
