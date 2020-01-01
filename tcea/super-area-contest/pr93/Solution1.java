import java.io.*;
import java.math.*;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.chrono.IsoChronology;
import java.util.*;

public class Solution1 {
    static Scanner sc, in;
    static PrintWriter out;

    static HashMap<String, Integer> DOW = new HashMap<>();
    static String[] month = { "", "JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC" };

    public static void main(String[] args) throws Exception {
        sc = in = new Scanner(new File("pr93.dat"));
        out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        DOW.put("SAT", 6);
        DOW.put("SUN", 7);
        DOW.put("MON", 1);
        DOW.put("TUE", 2);
        DOW.put("WED", 3);
        DOW.put("THU", 4);
        DOW.put("FRI", 5);

        int n = sc.nextInt();
        while (n-- > 0) {
            int dow = DOW.get(sc.next());
            int day = sc.nextInt();
            int k = sc.nextInt();
            int count = 0;
            label: {
                for (int y = 2000; y < 2100; y++) {
                    for (int m = 1; m <= 12; m++) {
                        try {
                            LocalDate date = LocalDate.of(y, m, day);
                            int cdow = date.getDayOfWeek().getValue();
                            if (cdow == dow) {
                                count++;
                                if (count == k) {
                                    out.println(month[m] + " " + y);
                                    break label;
                                }
                            }
                        } catch (Exception e) {
                        }
                    }
                }
            }
        }

        out.close();
    }
}