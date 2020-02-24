import java.util.*;
import java.io.*;

/*
The name of the world is not important so after reading each (x, y, z)
coordinate, you can call the scanner methods next() or nextLine() to skip
the world's name.
 */
public class Solution1 {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        double x = in.nextDouble();
        double y = in.nextDouble();
        double z = in.nextDouble();
        in.next();
        double distance = 0;
        for (int i = 0; i < 8; i++) {
            double x1 = in.nextDouble();
            double y1 = in.nextDouble();
            double z1 = in.nextDouble();
            in.next();
            distance += Math.sqrt(Math.pow(x - x1, 2) + Math.pow(y - y1, 2) + Math.pow(z - z1, 2));
            x = x1;
            y = y1;
            z = z1;
        }
        System.out.println("The tour is " + Math.round(distance) + " rost.");
    }
}