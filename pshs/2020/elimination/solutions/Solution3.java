
/**
 * @author Team A_PESH_BSOD
 */

import java.io.*;
import java.util.*;

public class Solution3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int mons = in.nextInt();
        int kill = in.nextInt();
        ArrayList<TreeMap<Long, String>> stats = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            stats.add(new TreeMap<>());
        }
        for (int i = 0; i < mons; i++) {
            String name = in.next();
            for (int j = 0; j < 6; j++) {
                stats.get(j).put(in.nextLong(), name);
            }
        }
        TreeSet<String> toKill = new TreeSet<>();
        for (int i = 0; i < 6; i++) {
            TreeMap<Long, String> curmap = stats.get(i);
            for (int j = 0; j < kill; j++) {
                toKill.add(curmap.pollFirstEntry().getValue());
            }
        }
        for (String i : toKill) {
            System.out.println(i);
        }
    }
}