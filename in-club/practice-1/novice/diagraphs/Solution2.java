import java.util.*;
import java.io.*;

/* 
This solution reads in the line from the input and creates an all lowercase
variant so we only need to call replace() 8 times with the lowercase diagraphs.
In addition, this solution also stores the lowercase diagraphs in an array so
we can use a for each loop to replace so we dont need to manually type 
replace() 8 times.
Afterwards, we want to essentially combine the original and the modified
lowercase strings. Because the lowercase string replaced some characters
to underscores, we can say that if we come across an underscore in the
lowercase string, we can add it to the combined string; otherwise add 
the characters from the original string.
 */
public class Solution2 {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        String[] diagraphs = { "sc", "ng", "ck", "ph", "sh", "th", "wh", "qu" };
        int t = in.nextInt();
        in.nextLine();
        for (int tc = 0; tc < t; tc++) {
            String line = in.nextLine();
            String lowercase = line.toLowerCase();
            for (String diagraph : diagraphs)
                lowercase = lowercase.replace(diagraph, "__");
            String fixed = "";
            for (int i = 0; i < lowercase.length(); i++)
                if (lowercase.charAt(i) == '_')
                    fixed += '_';
                else
                    fixed += line.charAt(i);
            System.out.println(fixed);
        }
    }
}