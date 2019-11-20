import java.io.*;
import java.math.*;
import java.util.*;

public class Solution1 {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new File("demo_clean_up.dat"));
        while(in.hasNextLine()){

            String[] nums = in.nextLine().split(",");
            int[] loads = new int[nums.length - 1];
            int capacity = Integer.parseInt(nums[0]);
            for (int i = 0; i < loads.length; i++) {
                loads[i] = Integer.parseInt(nums[i + 1]);
            }
            System.out.println(DP(capacity, loads));
        }
    }
    private static int DP(int cap, int[] loads){
        int left = cap;
        boolean has = false;
        for (int i = 0; i < loads.length; i++) {
            if(loads[i] == -1)
                continue;
            else if(loads[i] == left){
                loads[i] = -1;
                has = true;
                return 1 + DP(cap, loads);
            } else if(loads[i] < left){
                left -= loads[i];
                loads[i] = -1;
                has = true;
            } else if(loads[i] > left){
                has = true;
                continue;
            }
        }
        if(has)
            return 1 + DP(cap, loads);
        else if(left < cap)
            return 1 + DP(cap, loads);
        else
            return 0;
    }
}
