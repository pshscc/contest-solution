import java.util.*;
import java.io.*;

public class Solution4 {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        in.nextLine();
        for (int tc = 0; tc < t; tc++) {
            String line = in.nextLine();
            String fixed = line.replaceAll("(?i)sc|ng|ck|ph|sh|th|wh|qu", "__");
            System.out.println(fixed);
        }
    }
}