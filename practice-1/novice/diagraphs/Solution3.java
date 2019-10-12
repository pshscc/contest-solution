import java.util.*;
import java.io.*;

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