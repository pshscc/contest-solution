import java.io.*;
import java.util.*;

public class Solution1 {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        double d = in.nextDouble();
        double cps = n * 9 / d;
        System.out.println((int) cps);
    }
}