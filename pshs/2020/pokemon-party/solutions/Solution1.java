
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
        for (int x = 1; x <= n; x++)
            distributions.add(x);
        permutations = new ArrayList<>();
        permute(distributions, 0);
        ArrayList<Integer> init = new ArrayList<>(n);
        for (int x = 0; x < n; x++)
            init.add(0);
        recursion(init, n);
        System.out.println(count);
    }

    private static void recursion(ArrayList<Integer> s, int l) {
        if (l == 0) {
            int max = 0;
            for (int x : s)
                max = Math.max(max, x);
            if (s.get(0) == max) // pikachu is index 0
                count++;
        } else {
            for (ArrayList<Integer> distribution : permutations) {
                ArrayList<Integer> state = new ArrayList<>(s);
                for (int x = 0; x < distribution.size(); x++)
                    state.set(x, state.get(x) + distribution.get(x));
                recursion(state, l - 1);
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