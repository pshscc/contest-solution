
/**
 * @author Lance Pham
 */

import java.util.*;
import java.io.*;

public class Solution4 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String firstLine = in.readLine();
        int first = firstLine.indexOf(32);
        int second = firstLine.lastIndexOf(32);

        int numCustomers = Integer.parseInt(firstLine.substring(0, first));
        int numTypes = Integer.parseInt(firstLine.substring(first + 1, second));
        int numOrders = Integer.parseInt(firstLine.substring(second + 1));

        double totalLoss = 0.0;

        double[] balances = new double[numCustomers];
        Map<String, double[]> pancakes = new HashMap<>();

        // read store supply (bottleneck)
        for (int i = 0; i < numTypes; i++) {
            String line = in.readLine();
            first = line.indexOf(32);
            second = line.lastIndexOf(32);

            String name = line.substring(0, first);
            double price = Double.parseDouble(line.substring(first + 1, second));
            int quantity = Integer.parseInt(line.substring(second + 1));
            double[] info = { price, quantity };
            pancakes.put(name, info);
        }

        // read customer orders (bottleneck)
        for (int i = 0; i < numOrders; i++) {
            String line = in.readLine();
            first = line.indexOf(32);

            int customer = Integer.parseInt(line.substring(0, first));
            String order = line.substring(first + 1);
            double[] pancake = pancakes.get(order);

            // when inventory good
            if (pancakes.get(order)[1] > 0) {
                // adjust customer balance and inventory
                balances[customer - 1] += pancake[0];
                pancake[1]--;
                pancakes.put(order, pancake);
            } else {
                totalLoss += pancake[0];
            }
        }

        // output thingies
        for (int i = 0; i < numCustomers; i++) {
            System.out.printf("%3.2f ", balances[i]);
        }
        System.out.printf("\nTotal Loss: %3.2f", totalLoss);

    }
    // eof
}