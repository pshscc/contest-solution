
/**
 * @author JB Ladera
 */

import java.util.Scanner;

public class Solution2 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n-- > 0) {
            String s = sc.next();
            s = s.replaceAll("a+", "a").replaceAll("e+", "e").replaceAll("i+", "i").replaceAll("o+", "o")
                    .replaceAll("u+", "u");
            System.out.println(s);
        }
    }
}