import java.util.*;
import java.io.*;

/* 
You need to look at each line and get the transactions. The 
transactions can be stored as strings so that you can look
at the first digit easily by using charAt(0) or substring(0, 1).
Count how many start with 1s, 9s, and the total transactions
to calculate the percentages.
 */
public class Solution1 {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        in.nextLine();
        for (int tc = 0; tc < t; tc++) {
            String label = in.nextLine();
            String[] transactions = in.nextLine().split(" ");
            double count1 = 0;
            double count9 = 0;
            for (String transaction : transactions)
                if (transaction.charAt(0) == '1')
                    count1++;
                else if (transaction.charAt(0) == '9')
                    count9++;
            double percent1 = count1 / transactions.length;
            double percent9 = count9 / transactions.length;
            if (percent1 < .25 || percent9 > .1)
                System.out.println(label + " MUST BE INVESTIGATED FURTHER.");
            else
                System.out.println(label + " MEETS BENFORD'S LAW.");
        }
    }
}