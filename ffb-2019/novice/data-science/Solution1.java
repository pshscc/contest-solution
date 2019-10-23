import java.io.*;
import java.util.*;

public class Solution1 {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i = 0; i < t; i++){
            String first = in.next();
            String last = in.next();
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();
            int d = in.nextInt();
            int e = in.nextInt();
            int f = in.nextInt();
            int score = a+b+c+d+e+f;
            if(score >= 75)
                System.out.printf("%s %s %d %d %d %d %d %d Aggregate Score: %d\n",first,last,a,b,c,d,e,f,score);
        }
    }
}
