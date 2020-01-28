
/**
 * @author Team A_PWSH_Piada, modified by JB Ladera
 */

import java.io.*;
import java.util.*;

public class Solution3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int a = Integer.parseInt(input[1]);
        int b = Integer.parseInt(input[2]);
        HashSet<String> set = new HashSet<>();
        for (String s : br.readLine().split(" "))
            set.add(s);
        String[] ash = new String[set.size()];
        int x = 0;
        for (String s : set)
            ash[x++] = s;
        set.clear();
        for (String s : br.readLine().split(" "))
            set.add(s);
        String[] brock = new String[set.size()];
        x = 0;
        for (String s : set)
            brock[x++] = s;
        Arrays.sort(ash);
        Arrays.sort(brock);
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            int index = binSearch(ash, s);
            int aCount = 0;
            if (ash[index].startsWith(s)) {
                x = index;
                while (x < ash.length && ash[x++].startsWith((s)))
                    aCount++;
                x = index - 1;
                while (x >= 0 && ash[x--].startsWith(s))
                    aCount++;
            }
            index = binSearch(brock, s);
            int bCount = 0;
            if (brock[index].startsWith(s)) {
                x = index;
                while (x < brock.length && brock[x++].startsWith((s)))
                    bCount++;
                x = index - 1;
                while (x >= 0 && brock[x--].startsWith(s))
                    bCount++;
            }
            if (aCount < bCount) {
                System.out.println("Brock");
            } else if (bCount < aCount) {
                System.out.println("Ash");
            } else {
                System.out.println("neither");
            }
        }
    }

    private static int binSearch(String[] arr, String s) {
        int low = 0;
        int high = arr.length - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (arr[mid].startsWith(s)) {
                return mid;
            } else if (arr[mid].compareTo(s) < 0) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}