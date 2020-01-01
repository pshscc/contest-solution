import java.io.*;
import java.math.*;
import java.util.*;

public class Solution1 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new FileReader("pr54.dat"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        // StringTokenizer st = new StringTokenizer(in.readLine());

        int n = Integer.parseInt(in.readLine());
        HashMap<Integer, ArrayList<String>> nums = new HashMap<Integer, ArrayList<String>>();
        ArrayList<String> three = new ArrayList<String>();
        three.add("ONE");
        three.add("TWO");
        three.add("TEN");
        three.add("SIX");
        ArrayList<String> four = new ArrayList<String>();
        four.add("ZERO");
        four.add("FOUR");
        four.add("FIVE");
        four.add("NINE");
        ArrayList<String> five = new ArrayList<String>();
        five.add("EIGHT");
        five.add("THREE");
        five.add("SEVEN");
        nums.put(3, three);
        nums.put(4, four);
        nums.put(5, five);
        while (n-- > 0) {
            String s = in.readLine();
            int l = s.length();
            ArrayList<String> test = nums.get(l);
            int res = 0;
            for (String check : test) {
                int temp = 0;
                if ((temp = checkCipher(s, check)) >= 0) {
                    res = temp;
                    break;
                }
            }
            out.println(26 - res);
        }
        out.close();
    }

    public static int checkCipher(String word, String check) {
        if (word.equals(check))
            return 26;
        int counter = 1;
        char[] wordA = word.toCharArray();
        String temp = new String(word);
        char[] tempA = check.toCharArray();
        while (counter <= 25) {
            for (int j = 0; j < word.length(); j++) {
                tempA[j] = (tempA[j] == 'A' ? 'Z' : (char) (tempA[j] - 1));
            }
            // if(temp.equals(word)) return counter;
            int i;
            for (i = 0; i < tempA.length; i++) {
                if (tempA[i] != wordA[i])
                    break;
            }
            if (i >= tempA.length)
                return counter;
            counter++;
        }
        return -1;
    }
}