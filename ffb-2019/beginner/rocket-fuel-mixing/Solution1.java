import java.io.*;
import java.util.*;

public class Solution1 {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        double init = in.nextDouble();
        double fin = in.nextDouble();
        System.out.println((int)Math.round(a*(fin-init)));
    }
}
