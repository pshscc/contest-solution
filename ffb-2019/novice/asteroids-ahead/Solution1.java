import java.util.*;
import java.io.*;

public class Solution1 {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int first = Math.max(Math.max(in.nextInt(), in.nextInt()), in.nextInt());
        int second = Math.max(Math.max(in.nextInt(), in.nextInt()), in.nextInt());
        int third = Math.max(Math.max(in.nextInt(), in.nextInt()), in.nextInt());
        int boost = first + second + third;
        System.out.println(first + " " + second + " " + third + " Boost: " + boost);
    }
}