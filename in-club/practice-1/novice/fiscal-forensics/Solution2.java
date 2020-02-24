import java.util.*;
import java.io.*;

/* 
This is follows the same idea of Solution1 but uses
Scanner rather than split() when reading in the
transactions.
 */
public class Solution2 {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        in.nextLine();
        for (int tc = 0; tc < t; tc++) {
            String label = in.nextLine();
            Scanner transactions = new Scanner(in.nextLine());
            int count1 = 0;
            int count9 = 0;
            double total = 0;
            while (transactions.hasNext()) {
                String num = transactions.next();
                if (num.charAt(0) == '1')
                    count1++;
                else if (num.charAt(0) == '9')
                    count9++;
                total++;
            }
            double percent1 = count1 / total;
            double percent9 = count9 / total;
            if (percent1 < .25 || percent9 > .1)
                System.out.println(label + " MUST BE INVESTIGATED FURTHER.");
            else
                System.out.println(label + " MEETS BENFORD'S LAW.");
        }
    }
}