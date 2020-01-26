
/**
 * @author JB Ladera
 */

import java.io.*;
import java.util.*;

public class Solution1 {
    private static int count;
    private static ArrayList<ArrayList<Integer>> permutations;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> distributions = new ArrayList<>();
        for (int x = 0; x < n; x++)
            distributions.add(x + 1);
        permutations = new ArrayList<>();
        permute(distributions, 0);
        ArrayList<Integer> init = new ArrayList<>(n);
        for (int x = 0; x < n; x++)
            init.add(0);
        recursion(init, n);
        System.out.println(count);
    }

    private static void recursion(ArrayList<Integer> arr, int games) {
        if (games == 0) {
            int max = 0;
            for (int x = 0; x < arr.size(); x++)
                max = Math.max(max, arr.get(x));
            if (arr.get(0) == max)
                count++;
        } else {
            for (ArrayList<Integer> placement : permutations) {
                ArrayList<Integer> poke = new ArrayList<>(arr);
                for (int x = 0; x < placement.size(); x++)
                    poke.set(x, poke.get(x) + placement.get(x));
                recursion(poke, games - 1);
            }
        }
    }

    private static void permute(ArrayList<Integer> arr, int a) {
        for (int x = a; x < arr.size(); x++) {
            Collections.swap(arr, x, a);
            permute(arr, a + 1);
            Collections.swap(arr, a, x);
        }
        if (a == arr.size() - 1)
            permutations.add(new ArrayList<>(arr));
    }
}