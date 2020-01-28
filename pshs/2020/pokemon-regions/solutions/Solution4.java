
/**
 * @author Team A_PWSH_javaPals
 */

import java.io.*;
import java.util.*;

public class Solution4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numCases = scan.nextInt();
        scan.nextLine();
        Set<String> kanto = new TreeSet<String>();
        Set<String> johto = new TreeSet<String>();
        Set<String> hoenn = new TreeSet<String>();
        Set<String> sinnoh = new TreeSet<String>();
        for (int i = 0; i < numCases; i++) {
            String pokemon = scan.nextLine();
            int num = Integer.parseInt(pokemon.substring(0, 3));
            if (num > 386)
                sinnoh.add(pokemon);
            else if (num > 251)
                hoenn.add(pokemon);
            else if (num > 151)
                johto.add(pokemon);
            else
                kanto.add(pokemon);
        }
        Iterator<String> k = kanto.iterator();
        Iterator<String> j = johto.iterator();
        Iterator<String> h = hoenn.iterator();
        Iterator<String> s = sinnoh.iterator();
        System.out.println("Kanto:");
        while (k.hasNext())
            System.out.println(k.next());
        System.out.println("Johto:");
        while (j.hasNext())
            System.out.println(j.next());
        System.out.println("Hoenn:");
        while (h.hasNext())
            System.out.println(h.next());
        System.out.println("Sinnoh:");
        while (s.hasNext())
            System.out.println(s.next());
    }
}