import java.io.*;
import java.util.*;

public class Solution1 {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int weight = in.nextInt();
        if(weight > 6500)
            System.out.println("ABORT LAUNCH!");
        else if(weight == 6500)
            System.out.println(30000);
        else if(weight > 5000)
            System.out.println(Math.round(weight*5));
        else if(weight < 1000)
            System.out.println(Math.round(weight*1.5));
        else if(weight < 3000)
            System.out.println(Math.round(weight*2.25));
        else
            System.out.println(Math.round(weight*3.25));
    }
}
