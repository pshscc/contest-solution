import java.util.*;
import java.io.*;

/* 
For this solution, you can create a custom Comparable class that compares
the first two letters and the order in which they came in (this solution
represents that with the variable "index") if the first two letters are
the same. I create a Person array and keep track of their order as I read
in the names. Afterwards, use Arrays.sort() to sort it, and loop through the
array and print out their names.
Alternatively, you could use a TreeSet instead of an array since their
are no duplicate names, and the TreeSet will naturally sort it. This way
you could just loop through the TreeSet and print out the names.
 */
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