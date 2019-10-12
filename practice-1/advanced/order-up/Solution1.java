import java.util.*;
import java.io.*;

public class Solution1 {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        for (;;) { // same as while (true) but shorter
            int n = in.nextInt();
            if (n == 0)
                break;
            Person[] people = new Person[n];
            for (int i = 0; i < n; i++)
                people[i] = new Person(in.next(), i);
            Arrays.sort(people);
            for (Person p : people)
                System.out.println(p.name);
            System.out.println();
        }
    }
}

class Person implements Comparable<Person> {
    String name;
    String firstTwo;
    int index;

    public Person(String n, int i) {
        name = n;
        index = i;
        firstTwo = n.substring(0, 2);
    }

    public int compareTo(Person o) {
        if (firstTwo.equals(o.firstTwo))
            return index - o.index;
        return firstTwo.compareTo(o.firstTwo);
    }
}