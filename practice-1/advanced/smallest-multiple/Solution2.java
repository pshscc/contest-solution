import java.util.*;
import java.io.*;
import java.math.*;

public class Solution2 {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            Scanner line = new Scanner(in.nextLine());
            BigInteger lcm = line.nextBigInteger();
            while (line.hasNextBigInteger()) {
                BigInteger num = line.nextBigInteger();
                lcm = lcm.multiply(num).divide(lcm.gcd(num));
            }
            System.out.println(lcm);
        }
    }
}