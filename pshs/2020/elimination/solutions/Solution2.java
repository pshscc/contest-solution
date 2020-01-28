
/**
 * @author JB Ladera
 */

import java.util.Scanner;
import java.util.TreeSet;

@SuppressWarnings("unchecked")
public class Solution2 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        TreeSet<Poke>[] stats = new TreeSet[6];
        for (int x = 0; x < stats.length; x++)
            stats[x] = new TreeSet<>();
        for (int x = 0; x < N; x++) {
            String name = sc.next();
            for (int i = 0; i < stats.length; i++) {
                long stat = sc.nextLong();
                stats[i].add(new Poke(name, stat));
            }
        }
        TreeSet<String> names = new TreeSet<>();
        for (int x = 0; x < stats.length; x++)
            for (int i = 0; i < K; i++)
                names.add(stats[x].pollFirst().name);
        for (String name : names)
            System.out.println(name);
    }

    private static class Poke implements Comparable<Poke> {
        String name;
        long stat;

        public Poke(String name, long stat) {
            this.name = name;
            this.stat = stat;
        }

        public int compareTo(Poke o) {
            return Long.compare(stat, o.stat);
        }
    }
}