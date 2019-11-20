import java.io.*;
import java.math.*;
import java.util.*;

public class Solution1 {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new File("word_mix.dat"));
        char[] a = in.next().toCharArray();
        char[] b = in.next().toCharArray();
        for(int i = 0; i < a.length; i++){
            if(i%2 == 0)
                System.out.print(a[i]);
            else
                System.out.print(b[i]);
        }
    }
}
