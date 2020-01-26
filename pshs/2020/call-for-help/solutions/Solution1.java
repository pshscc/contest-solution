
/**
 * @author Lauren Kim
 */

import java.util.*;
import java.io.*;

public class Solution1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        String name = in.next();
        int K = in.nextInt();
        if (N < K)
            System.out.println(name + " is too strong! Call for help!");
        else if (N > K)
            System.out.println("Success!");
        else
            System.out.println("Draw!");
    }
}