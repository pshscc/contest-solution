import java.util.*;
import java.io.*;
import java.math.*;

/* 
This follows the same idea of Solution1 but uses Scanner and its
nextBigInteger() and hasNextBigInteger().
*/
public class Solution2 {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            Scanner line = new Scanner(in.nextLine());
            BigInteger lcm = line.nextBigInteger();
            while (line.hasNextBigInteger()) {
                BigInteger num = line.nextBigInteger();
                lcm = lcm.multiply(num).divide(lcm.gcd(num));
                // BigInteger, like String, is immutable.
            }
            System.out.println(lcm);
        }
    }
}