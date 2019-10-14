import java.util.*;
import java.io.*;

/* 
You can hard code each variation of (sc, ng, ck, ph, sh, th, wh, qu)
and replace them with underscores. However, the time it takes to type this
makes it not the most favorable option.
 */
public class Solution1 {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        String r = "__";
        int t = in.nextInt();
        in.nextLine();
        for (int tc = 0; tc < t; tc++) {
            String line = in.nextLine();
            String fixed = line.replace("sc", r).replace("Sc", r).replace("sC", r).replace("SC", r).replace("ng", r)
                    .replace("Ng", r).replace("nG", r).replace("NG", r).replace("ck", r).replace("Ck", r)
                    .replace("cK", r).replace("ph", r).replace("Ph", r).replace("pH", r).replace("PH", r)
                    .replace("sh", r).replace("Sh", r).replace("sH", r).replace("SH", r).replace("th", r)
                    .replace("Th", r).replace("tH", r).replace("TH", r).replace("wh", r).replace("Wh", r)
                    .replace("wH", r).replace("WH", r).replace("qu", r).replace("Qu", r).replace("qU", r)
                    .replace("QU", r);
            System.out.println(fixed);
        }
    }
}