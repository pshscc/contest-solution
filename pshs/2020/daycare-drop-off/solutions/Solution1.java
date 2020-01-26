
/**
 * @author JB Ladera
 */

import java.util.Scanner;

public class Solution1 {
    private static int MAX = (int) 1e6;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int Q = sc.nextInt();
        double K = sc.nextInt();
        int[] pokemon = new int[MAX + 1];
        while (N-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            pokemon[a]++;
            pokemon[b]--;
        }
        for (int x = 1; x < pokemon.length; x++)
            pokemon[x] += pokemon[x - 1];
        while (Q-- > 0) {
            int d = sc.nextInt();
            int ans = (int) Math.ceil(pokemon[d] / K);
            System.out.println(ans);
        }
    }
}