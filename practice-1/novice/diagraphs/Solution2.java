import java.util.*;
import java.io.*;

/*  
This is similar to Solution1, but instead we create a method that
performs the replacing of the diagraphs. We create an array with
all the lowercase diagraphs and loop through it to get the 3
other variations and replace them accordingly. I find this
faster to type than Solution1
*/
public class Solution2 {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        in.nextLine();
        for (int tc = 0; tc < t; tc++) {
            String line = in.nextLine();
            String fixed = modify(line);
            System.out.println(fixed);
        }
    }

    static String modify(String line) {
        String r = "__";
        String[] diagraphs = { "sc", "ng", "ck", "ph", "sh", "th", "wh", "qu" };
        for (String diagraph : diagraphs) {
            String uppercase = diagraph.toUpperCase();
            String bigsmall = uppercase.substring(0, 1) + diagraph.substring(1);
            String smallbig = diagraph.substring(0, 1) + uppercase.substring(1);
            line = line.replace(diagraph, r).replace(uppercase, r).replace(bigsmall, r).replace(smallbig, r);
        }
        return line;
    }
}