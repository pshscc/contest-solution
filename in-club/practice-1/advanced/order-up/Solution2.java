import java.util.*;
import java.io.*;

/* 
In this explanation, I will refer to the first two letters as F.

This solution uses a TreeMap where the key represents F and the value
is an arraylist containing the names of that start with F. The use of
a TreeMap allows F to be in sorted order when we loop through it in the end.
When reading in the names, add it to the end of the respective arraylist.
As a result when printing out the output, names that have the same F will be
in order in which they appeared in.
 */
public class Solution2 {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        for (;;) { // same as while (true) but shorter
            int n = in.nextInt();
            if (n == 0)
                break;
            Map<String, List<String>> map = new TreeMap<>();
            for (int i = 0; i < n; i++) {
                String name = in.next();
                String firstTwo = name.substring(0, 2);
                if (!map.containsKey(firstTwo))
                    map.put(firstTwo, new ArrayList<>());
                map.get(firstTwo).add(name);
            }
            for (String firstTwo : map.keySet())
                for (String name : map.get(firstTwo))
                    System.out.println(name);
            System.out.println();
        }
    }
}