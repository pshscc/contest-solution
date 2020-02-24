import java.util.*;
import java.io.*;

/*  
This is, in my opinion, the best solution to this problem.
Unlike Solution3 where we had to hard code the lowercase and uppercase
letter, we can use the embedded flag expression (?i) to say that
the following regex should be case insensitive. This was not
covered in CS3. You can read the documention for more information.
https://docs.oracle.com/javase/8/docs/api/java/util/regex/Pattern.html#CASE_INSENSITIVE
*/
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