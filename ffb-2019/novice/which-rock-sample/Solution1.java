import java.io.*;
import java.util.*;

public class Solution1 {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        while((line = in.readLine()) != null) {
            if(line.length() == 1) continue; // workaround for bad judge data
            String[] input = line.split(" ");
            int x = Integer.parseInt(input[0]);
            int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
            for(int i = 1; i <= x; i++) {
                int num = Integer.parseInt(input[i]);
                min = Math.min(min, num);
                max = Math.max(max, num);
            }
            if(min >= 3) {
                System.out.println("Uh oh");
            }            
            else if(min == max)
                System.out.println(min);
            else
                System.out.println(min + " " + max);
        }
    }
}
