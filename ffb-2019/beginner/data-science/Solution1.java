import java.io.*;
import java.util.*;

public class Solution1 {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();
        if(a >= 10 && a <= 20 && a != 13 && a != 17)
            a = 0;
        if(b >= 10 && b <= 20 && b != 13 && b != 17)
            b = 0;
        if(c >= 10 && c <= 20 && c != 13 && c != 17)
            c = 0;
        System.out.println(a+b+c);
    }
}
