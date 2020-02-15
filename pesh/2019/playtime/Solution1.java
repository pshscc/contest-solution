import java.io.*;
import java.math.*;
import java.util.*;

public class Solution1 {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new File("playtime.dat"));
        int n = in.nextInt();
        in.nextLine();
        for (int i = 0; i < n; i++) {
            String[] input = in.nextLine().split(",");
            System.out.print(input[0] + " - ");
            final int MIN_YR = 365 * 24 * 60;
            final int MIN_DAY = 24 * 60;
            final int MIN_HR = 60;

            int time = Integer.parseInt(input[1]);
            int year = 0, hour = 0, min = 0, day = 0;
            if (time / MIN_YR > 0) {
                year = time / MIN_YR;
                time -= MIN_YR * year;
                System.out.print(year + " year(s) ");
            }
            if (time / MIN_DAY > 0) {
                day = time / MIN_DAY;
                time -= MIN_DAY * day;
                System.out.print(day + " day(s) ");
            }
            if (time / MIN_HR > 0) {
                hour = time / MIN_HR;
                time -= MIN_HR * hour;
                System.out.print(hour + " hour(s) ");
            }
            System.out.println(time + " minute(s)");
        }
    }
}
