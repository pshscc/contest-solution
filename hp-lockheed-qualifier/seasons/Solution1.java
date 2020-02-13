
/**
 * @author Shakeel Samsudeen
 */

import java.io.*;
import java.util.*;
import java.math.*;
import java.time.*;

public class Solution1 {
    static BufferedReader in;
    static PrintWriter out;
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(in.readLine());
        HashMap<String, Integer> months = new HashMap<String, Integer>();
        months.put("January", 1);
        months.put("February", 2);
        months.put("March", 3);
        months.put("April", 4);
        months.put("May", 5);
        months.put("June", 6);
        months.put("July", 7);
        months.put("August", 8);
        months.put("September", 9);
        months.put("October", 10);
        months.put("November", 11);
        months.put("December", 12);
        while (n-- > 0) {
            int d = Integer.parseInt(in.readLine());
            st = new StringTokenizer(in.readLine());
            String monthTemp = st.nextToken();
            String dayTemp = st.nextToken();
            int day = Integer.parseInt(dayTemp.substring(0, dayTemp.length() - 1));
            int month = months.get(monthTemp);
            int year = Integer.parseInt(st.nextToken());
            // with Date related problems, we highly recommend using
            // LocalDate (in java.time) and the java.time package.
            // The java.time package was made to replace
            // classes such as Date and Calendar. Utilize the
            // Java API to understand the methods of LocalDate
            // and other java.time stuff if needed.
            LocalDate date = LocalDate.of(year, month, day);
            while (d >= 0) {
                if (date.getMonthValue() <= 4) {
                    d -= 3;
                    date = date.plusDays(1);
                } else if (date.getMonthValue() <= 8) {
                    d -= 5;
                    date = date.plusDays(1);
                } else {
                    d--;
                    date = date.plusDays(1);
                }
            }
            String outMonth = date.getMonth().toString();
            out.println(outMonth.substring(0, 1) + outMonth.substring(1).toLowerCase() + " "
                    + String.format("%02d", date.getDayOfMonth() - 1) + ", " + date.getYear());
        }
        out.close();
    }
}