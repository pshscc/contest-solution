import java.io.*;
import java.math.*;
import java.util.*;

public class Solution1 {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new File("triangle_height.dat"));
        int n = in.nextInt();
        in.nextLine();
        for(int i = 0; i < n; i ++){
            String[] arr = in.nextLine().split(",");
            double a = Double.parseDouble(arr[0]);
            double b = Double.parseDouble(arr[1]);
            double h = 0;
            if(b == 0)
                h = a;
            else
                h = 2 * a / b;
            System.out.printf("%s %.2f units\n","The height of the triangle is",h);
        }
    }
}
