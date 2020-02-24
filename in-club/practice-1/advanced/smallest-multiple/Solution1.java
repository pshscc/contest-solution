import java.util.*;
import java.io.*;
import java.math.*;

/* 
Know that the least common multiple (lcm) of two numbers, a and b, can be
represented by the formula: lcm = a * b / gcd(a, b)
where gcd(a, b) is the greatest common divisor of a and b.
The lcm of multiple numbers, a, b, and c, can be calculated by as
such: lcm(lcm(a, b), c)

Because the numbers in the input can be as large as 2^{32} and at most
100 numbers on each line, int and long will not work as they will overflow.
Therefore, this problem requires the use of BigInteger (this has not been covered
in the club yet), which can be found in the java.math package.
Read and store the first number of each line in a variable and update the variable
with the lcm of each number that you read in. This will result in the variable to
contain the lcm of all the numbers.
 */
public class Solution1 {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String[] nums = in.nextLine().split(" ");
            BigInteger lcm = new BigInteger(nums[0]);
            for (int i = 1; i < nums.length; i++) {
                BigInteger num = new BigInteger(nums[i]);
                lcm = lcm.multiply(num).divide(lcm.gcd(num));
                // BigInteger, like String, is immutable.
            }
            System.out.println(lcm);
        }
    }
}