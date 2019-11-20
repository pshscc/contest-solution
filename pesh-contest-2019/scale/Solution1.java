import java.io.*;
import java.math.*;
import java.util.*;

public class Solution1 {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new File("scale.dat"));
        while(in.hasNextLine()){
            String[] s = in.nextLine().split(" ");
            long[] nums = new long[s.length];
            for(int i = 0; i < nums.length; i++){
                nums[i] = Long.parseLong(s[i]);
            }
            for(int i = 0; i < nums.length; i++){
                if(i == 0)
                    System.out.print(nums[0]*nums[1] + " ");
                else if(i == nums.length-1)
                    System.out.print(nums[nums.length-1]*nums[nums.length-2] + " ");
                else
                    System.out.print(nums[i]*nums[i+1]*nums[i-1] + " ");
            }
            System.out.println();
        }
    }
}
