
/**
 * @author JB Ladera
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Solution1 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<String> max = new ArrayList<>();
        ArrayList<String> min = new ArrayList<>();
        int maxprice = -1;
        int minprice = (int) 1e10;
        while (n-- > 0) {
            String name = sc.next();
            double price = sc.nextDouble();
            int quantity = sc.nextInt();
            int p = (int) (price * 100);
            int cost = p * quantity;
            if (cost >= maxprice) {
                if (cost > maxprice) {
                    maxprice = cost;
                    max.clear();
                }
                max.add(name);
            }
            if (cost <= minprice) {
                if (cost < minprice) {
                    minprice = cost;
                    min.clear();
                }
                min.add(name);
            }
        }
        for (int x = 0; x < max.size(); x++)
            System.out.print(max.get(x) + " ");
        System.out.println();
        for (int x = 0; x < min.size(); x++)
            System.out.print(min.get(x) + " ");
    }
}