/**
 * @author JB Ladera
 */

import java.io.*;
import java.util.*;

public class Solution1 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int t = sc.nextInt();
        int p = sc.nextInt();
        double q = sc.nextInt();
        int days = (int) Math.ceil((t - s) * q / p);
        System.out.println(days);
    }
}