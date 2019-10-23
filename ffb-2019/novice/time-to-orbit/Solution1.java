import java.io.*;
import java.util.*;

public class Solution1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Integer> x = new ArrayList<Integer>();
        while(in.hasNextInt()) {
            x.add(in.nextInt());
            Collections.sort(x);
            if(x.size()%2==1)
                System.out.println(x.get(x.size()/2));
            else {
                double result = (x.get(x.size()/2) + x.get(x.size()/2-1))/2.0;
                if(result%1==0)
                    System.out.println((int)result);
                else
                    System.out.println(result);
            }
        }
    }
}