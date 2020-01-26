
/**
 * @author JB Ladera
 */

import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

public class Solution1 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), K = sc.nextInt();
        Poke[][] arr = new Poke[6][N];
        for (int c = 0; c < N; c++) {
            String name = sc.next();
            long[] stats = new long[6];
            for (int x = 0; x < stats.length; x++)
                stats[x] = sc.nextLong();
            Poke poke = new Poke(name, stats);
            for (int r = 0; r < 6; r++)
                arr[r][c] = poke;
        }
        for (int r = 0; r < arr.length; r++) {
            int row = r;
            Arrays.sort(arr[r], (a, b) -> Long.compare(a.stats[row], b.stats[row]));
        }
        TreeSet<String> set = new TreeSet<>();
        for (int r = 0; r < arr.length; r++)
            for (int c = 0; c < K; c++)
                set.add(arr[r][c].name);
        for (String s : set)
            System.out.println(s);
    }

    private static class Poke {
        String name;
        long[] stats;

        public Poke(String name, long[] stats) {
            this.name = name;
            this.stats = stats;
        }
    }
}