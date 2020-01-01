import java.io.*;
import java.math.*;
import java.util.*;

public class Solution1 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new FileReader("pr56.dat"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int n = Integer.parseInt(in.readLine());
        while (n-- > 0) {
            ArrayList<Word> words = new ArrayList<Word>();
            StringTokenizer st = new StringTokenizer(in.readLine());
            while (st.hasMoreTokens()) {
                Word w = new Word(st.nextToken());
                w.calcPercentage();
                words.add(w);
            }
            Collections.sort(words);
            out.println(words.get(0).word);
        }
        out.close();
    }
}

class Word implements Comparable<Word> {
    String word;
    int l;
    double percentage;

    public Word(String word) {
        this.word = word;
        this.l = word.length();
    }

    public int compareTo(Word w) {
        if (percentage == w.percentage)
            return w.l - l;
        return (int) ((percentage - w.percentage) * 100);
    }

    public void calcPercentage() {
        String regex = "[RSTLNE]";
        String temp = word.replaceAll(regex, "");
        percentage = (double) (l - temp.length()) / l;
        // System.out.println(word + " " + temp + " " + percentage);
    }

    public String toString() {
        return word + " " + percentage;
    }
}