
/**
 * @author JB Ladera
 */

import java.io.*;
import java.util.*;

public class Solution3 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String[] arr = new String[500];
        int n = sc.nextInt();
        while (n-- > 0) {
            int a = sc.nextInt();
            String name = sc.next();
            arr[a] = name;
        }
        for (int x = 0; x < arr.length; x++) {
            if (x == 1)
                System.out.println("Kanto:");
            else if (x == 152)
                System.out.println("Johto:");
            else if (x == 252)
                System.out.println("Hoenn:");
            else if (x == 387)
                System.out.println("Sinnoh:");
            if (arr[x] != null)
                System.out.printf("%03d %s\n", x, arr[x]);
        }
    }
}