import java.io.*;
import java.util.*;

public class Solution1 {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int i = 0; i < n; i++){
            int operator = in.nextInt();
            int a = in.nextInt();
            int b = in.nextInt();
            if(operator == 0)
                System.out.println(a+b);
            if(operator == 1)
                System.out.println(a-b);
            if(operator == 2)
                System.out.println(a*b);
            if(operator == 3)
                System.out.println(a/b);
        }
    }
}
