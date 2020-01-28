
/**
 * @author JB Ladera
 */

import java.io.*;
import java.util.*;

public class Solution1 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n-- > 0) {
            char[] arr = sc.next().toCharArray();
            String res = "" + arr[0];
            for (int x = 1; x < arr.length; x++) {
                if (!isVowel(arr[x]) || arr[x] != res.charAt(res.length() - 1))
                    res += arr[x];
            }
            System.out.println(res);
        }
    }

    private static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}