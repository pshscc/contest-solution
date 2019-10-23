import java.io.*;
import java.util.*;

public class Solution1 {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        double one = in.nextDouble();
        double two = in.nextDouble();
        double a = Math.min(one,two);
        double b = Math.max(one,two);
        
        if(a == b || b/a > 4.45)
            System.out.println((int)a);
        else
            System.out.println((int)Math.floor(Math.max(a,b)/4.45));
    }
}
