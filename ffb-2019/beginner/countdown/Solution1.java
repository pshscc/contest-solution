import java.io.*;
import java.util.*;

public class Solution1 {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int start = in.nextInt();
        for(int i = start; i >= 1; i--){
            if(i == 20){
                System.out.println("T-minus 20 Hold for final status check\nAll systems nominal, we are a GO for launch");
                i = 16;
            }
            else if(i == 120)
                System.out.println("T-minus 120 Crew members close and lock their visors");
            else if(i == 50)
                System.out.println("T-minus 50 Mission vehicle transfers from ground to internal power");
            else if(i > 9)
                System.out.println("T-minus " + i);
            else if(i == 6){
                System.out.println("6 Main Engine start\n");
                i--;
            }
            else
                System.out.println(i);
        }
        System.out.println("Blast off!");
    }
}
