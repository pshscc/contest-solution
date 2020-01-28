
/**
 * @author Lauren Kim
 */

import java.util.*;
import java.io.*;

public class Solution1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int L = in.nextInt();
        String S = in.next();
        int P = in.nextInt();
        if (L < P)
            System.out.println(S + " is too strong! Call for help!");
        else if (L > P)
            System.out.println("Success!");
        else
            System.out.println("Draw!");
    }
}