
/**
 * @author JB Ladera
 */

import java.io.*;
import java.util.*;

public class Solution1 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<String> max = new ArrayList<>();
        ArrayList<String> min = new ArrayList<>();
        double maxPrice = -1;
        double minPrice = 1e10;
        while (n-- > 0) {
            String name = sc.next();
            double price = sc.nextDouble();
            int quantity = sc.nextInt();
            double cost = price * quantity;
            if (cost >= maxPrice) {
                if (cost > maxPrice) {
                    maxPrice = cost;
                    max.clear();
                }
                max.add(name);
            }
            if (cost <= minPrice) {
                if (cost < minPrice) {
                    minPrice = cost;
                    min.clear();
                }
                min.add(name);
            }
        }
        for (String s : max)
            System.out.print(s + " ");
        System.out.println();
        for (String s : min)
            System.out.print(s + " ");
    }
}
