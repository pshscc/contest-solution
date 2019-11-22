import java.io.*;
import java.util.*;

public class Solution2 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String[] line = sc.nextLine().split(" ");
            Stack<String> v = new Stack<>();
            for (int x = 0; x < line.length; x++)
                if (line[x].matches("(?i)^[aeiou].*")) {
                    v.add(line[x]);
                    line[x] = null;
                }
            for (int x = 0; x < line.length; x++)
                System.out.print(line[x] == null ? v.pop() + " " : line[x] + " ");
            System.out.println();
        }
    }
}