import java.io.*;
import java.util.*;

public class Solution1 {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        String b = in.next();
        double c = in.nextDouble();
        if(b.equals("g"))
            a /= 1000;
        //double weight = a*9.8;
        double accel = (c-a)/(a/10);
        System.out.println(accel);
    }
}
