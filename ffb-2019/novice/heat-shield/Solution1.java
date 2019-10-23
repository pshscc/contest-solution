import java.io.*;
import java.util.*;

public class Solution1 {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        double start = in.nextDouble();
        double inc = in.nextDouble();
        double shield = in.nextDouble();
        double time = (double) (shield - start) / inc;
        int round = (int) Math.ceil(time);
        if (round > 70)
            System.out.println("We made it! " + round);
        else
            System.out.println("Fail.");
    }
}