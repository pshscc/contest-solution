import java.util.*;
import java.io.*;

/*  
Another way to solve this is to use Regular Expressions aka regex
(CS3 students have already learned this). You could simiplify
the regex that I used, but sometimes the time it takes to simplify
is longer than just hard coding it which makes it not worth doing.
*/
public class Solution3 {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        in.nextLine();
        for (int tc = 0; tc < t; tc++) {
            String line = in.nextLine();
            String fixed = line.replaceAll("[sS][cC]|[nN][gG]|[cC][kK]|[pP][hH]|[sS][hH]|[tT][hH]|[wW][hH]|[qQ][uU]", "__");
            System.out.println(fixed);
        }
    }
}