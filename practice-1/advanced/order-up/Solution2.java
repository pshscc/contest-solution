import java.util.*;
import java.io.*;

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