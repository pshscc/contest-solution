import java.io.*;
import java.util.*;

public class Solution1 {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        double w = in.nextDouble();
        double f = in.nextDouble();
        double n = in.nextDouble();
        double g = w / n * f;
        System.out.println((int) g);
    }
}