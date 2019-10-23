import java.io.*;
import java.util.*;

public class Solution1 {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int sugar = in.nextInt();
        int milk = in.nextInt();
        int temp = in.nextInt();
        if (sugar == 2 && milk == 1 && temp >= 100 && temp <= 120)
            System.out.println("Good coffee!");
        else
            System.out.println("Terrible coffee");
    }
}