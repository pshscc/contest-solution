import java.io.*;
import java.math.*;
import java.util.*;

public class Solution1 {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new File("reverse.dat"));
        String[] words;
        String vowelList = "aeiouAEIOU";
        while (in.hasNextLine()) {
            words = in.nextLine().split(" ");
            Stack<String> vo = new Stack<String>();
            for (int k = 0; k < words.length; k++) {
                if (-1 != vowelList.indexOf(words[k].charAt(0)))
                    vo.push(words[k]);
            }
            for (int j = 0; j < words.length; j++) {
                if (-1 != vowelList.indexOf(words[j].charAt(0)))
                    System.out.print(vo.pop() + " ");
                else
                    System.out.print(words[j] + " ");
            }
            System.out.println();
        }
    }
}
