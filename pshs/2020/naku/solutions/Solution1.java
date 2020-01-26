
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
            char[] res = new char[arr.length];
            res[0] = arr[0];
            int i = 1;
            for (int x = 1; x < arr.length; x++) {
                if (!isVowel(arr[x]) || arr[x] != res[i - 1])
                    res[i++] = arr[x];
            }
            System.out.println(new String(res, 0, i));
        }
    }

    private static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}