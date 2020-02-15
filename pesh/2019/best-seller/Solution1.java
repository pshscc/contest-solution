import java.io.*;
import java.util.*;

public class Solution1 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("best_seller.data"));
        ArrayList<Item> items = new ArrayList<>();
        while (sc.hasNextLine()) {
            String[] line = sc.nextLine().split(",");
            int n = Integer.parseInt(line[1]);
            double p = Double.parseDouble(line[2].substring(1));
            items.add(new Item(line[0], n, p));
        }
        items.sort(null);
        for (Item x : items)
            System.out.println(x);
    }

    static class Item implements Comparable<Item> {
        String name;
        int n;
        double p, profit;

        public Item(String a, int b, double c) {
            name = a;
            n = b;
            p = c;
            profit = n * p;
        }

        public int compareTo(Item o) {
            if (profit == o.profit) {
                if (n == o.n)
                    return name.compareTo(o.name);
                return o.n - n;
            }
            return Double.compare(o.profit, profit);
        }

        public String toString() {
            return String.format("$%.2f - %s/%d", profit, name, n);
        }
    }
}