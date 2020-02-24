import java.util.*;
import java.io.*;

public class Solution1 {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int casualties = in.nextInt();
        System.out.println("Help! The Statesman is under attack! We have " + (1000 - casualties) + " survivors.");
    }
}