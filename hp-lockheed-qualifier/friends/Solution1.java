
/**
 * @author Shakeel Samsudeen
 */

import java.io.*;
import java.util.*;
import java.math.*;

public class Solution1 {
    static BufferedReader in;
    static PrintWriter out;
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine());
            ArrayList<Person> people = new ArrayList<Person>();
            while (n-- > 0) {
                st = new StringTokenizer(in.readLine());
                people.add(new Person(st.nextToken(), Integer.parseInt(st.nextToken())));
            }
            Collections.sort(people);
            String outA = "";
            for (Person p : people)
                outA += p.name + ", ";
            outA = outA.substring(0, outA.length() - 2);
            out.println(outA);

        }
        out.close();
    }
}

class Person implements Comparable<Person> {
    int x;
    String name;

    public Person(String name, int x) {
        this.x = x;
        this.name = name;
    }

    public int compareTo(Person p) {
        return p.x - this.x;
    }
}