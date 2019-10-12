import java.util.*;
import java.io.*;
import java.math.*;

public class Solution1 {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String[] nums = in.nextLine().split(" ");
            BigInteger lcm = new BigInteger(nums[0]);
            for (int i = 1; i < nums.length; i++) {
                BigInteger num = new BigInteger(nums[i]);
                lcm = lcm.multiply(num).divide(lcm.gcd(num));
            }
            System.out.println(lcm);
        }
    }
}