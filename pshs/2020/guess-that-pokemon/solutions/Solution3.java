
/**
 * @author JB Ladera
 */

import java.io.*;
import java.util.*;

public class Solution3 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        HashSet<String> set = new HashSet<>();
        int n = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        while (a-- > 0)
            set.add(sc.next());
        String[] ash = set.toArray(new String[set.size()]);
        set.clear();
        while (b-- > 0)
            set.add(sc.next());
        String[] brock = set.toArray(new String[set.size()]);
        Arrays.sort(ash);
        Arrays.sort(brock);
        while (n-- > 0) {
            String p = sc.next();
            int index = binarySearch(ash, p);
            int aCount = 0;
            if (index != -1) {
                int q = index;
                while (q < ash.length && ash[q++].startsWith((p)))
                    aCount++;
                q = index - 1;
                while (q >= 0 && ash[q--].startsWith(p))
                    aCount++;
            }
            index = binarySearch(brock, p);
            int bCount = 0;
            if (index != -1) {
                int q = index;
                while (q < brock.length && brock[q++].startsWith((p)))
                    bCount++;
                q = index - 1;
                while (q >= 0 && brock[q--].startsWith(p))
                    bCount++;
            }
            if (aCount < bCount)
                System.out.println("Brock");
            else if (aCount > bCount)
                System.out.println("Ash");
            else
                System.out.println("neither");
        }
    }

    private static int binarySearch(String[] arr, String s) {
        int lo = 0;
        int hi = arr.length - 1;
        while (lo <= hi) {
            int m = (lo + hi) / 2;
            if (arr[m].startsWith(s))
                return m;
            if (arr[m].compareTo(s) < 0)
                lo = m + 1;
            else
                hi = m - 1;
        }
        return -1;
    }
}