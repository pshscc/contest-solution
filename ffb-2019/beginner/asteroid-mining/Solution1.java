import java.io.*;
import java.util.*;

public class Solution1 {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        double n = in.nextDouble();
        int m = 0;
        int k = 1;
        while (n > 20) {
            n /= 3;
            m += k;
            k *= 3;
        }
        System.out.println(m);
    }
}