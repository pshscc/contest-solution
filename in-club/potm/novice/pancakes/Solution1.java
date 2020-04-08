/**
 * @author Shakeel Samsudeen
 */

import java.io.*;
import java.util.*;

public class Solution1 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(in.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        HashMap<String, Item> items = new HashMap<String, Item>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(in.readLine());
            String name = st.nextToken();
            items.put(name, new Item(name, Double.parseDouble(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        double[] customers = new double[n];
        double loss = 0;
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(in.readLine());
            int c = Integer.parseInt(st.nextToken());
            String p = st.nextToken();
            Item x = items.get(p);
            if (x.quantity == 0) {
                loss += x.price;
            } else {
                customers[c - 1] += x.price;
                x.quantity--;
            }
        }
        out.printf("%.2f", customers[0]);
        for (int i = 1; i < customers.length; i++)
            out.printf(" %.2f", customers[i]);
        out.println();
        out.printf("Total Loss: %.2f", loss);
        out.close();
    }
}

class Item {
    String name;
    double price;
    int quantity;

    public Item(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
}
