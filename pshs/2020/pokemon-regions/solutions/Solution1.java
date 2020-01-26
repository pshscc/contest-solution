
/**
 * @author Andrew Gazda
 */

import java.util.*;
import java.io.*;

public class Solution1 {
    public static void main(String args[]) throws Exception {
        Scanner in = new Scanner(System.in);
        Map<String, TreeMap<Integer, String>> reg = new TreeMap<String, TreeMap<Integer, String>>();
        String[] t = { "Kanto:", "Johto:", "Hoenn:", "Sinnoh:" };
        int c = in.nextInt();
        for (int i = c; i > 0; i--) {
            int num = in.nextInt();
            String pokemon = in.next();
            if (num <= 151) {
                if (reg.containsKey("Kanto")) {
                    reg.get("Kanto").put(num, pokemon);
                } else {
                    reg.put("Kanto", new TreeMap<Integer, String>());
                    reg.get("Kanto").put(num, pokemon);
                }

            } else if (num <= 251) {
                if (reg.containsKey("Johto")) {
                    reg.get("Johto").put(num, pokemon);
                } else {
                    reg.put("Johto", new TreeMap<Integer, String>());
                    reg.get("Johto").put(num, pokemon);
                }
            } else if (num <= 386) {
                if (reg.containsKey("Hoenn")) {
                    reg.get("Hoenn").put(num, pokemon);
                } else {
                    reg.put("Hoenn", new TreeMap<Integer, String>());
                    reg.get("Hoenn").put(num, pokemon);
                }
            } else {
                if (reg.containsKey("Sinnoh")) {
                    reg.get("Sinnoh").put(num, pokemon);
                } else {
                    reg.put("Sinnoh", new TreeMap<Integer, String>());
                    reg.get("Sinnoh").put(num, pokemon);
                }
            }
        }
        Iterator<String> it = reg.keySet().iterator();
        int gen = 0;
        while (it.hasNext()) {
            System.out.println(t[gen]);
            String y = it.next();
            if (gen == 0) {
                for (Map.Entry<Integer, String> k : reg.get("Kanto").entrySet()) {
                    System.out.println(String.format("%03d %s", k.getKey(), k.getValue()));
                }
            } else if (gen == 1) {
                for (Map.Entry<Integer, String> k : reg.get("Johto").entrySet()) {
                    System.out.println(String.format("%03d %s", k.getKey(), k.getValue()));
                }
            } else if (gen == 2) {
                for (Map.Entry<Integer, String> k : reg.get("Hoenn").entrySet()) {
                    System.out.println(String.format("%03d %s", k.getKey(), k.getValue()));
                }
            } else {
                for (Map.Entry<Integer, String> k : reg.get("Sinnoh").entrySet()) {
                    System.out.println(String.format("%03d %s", k.getKey(), k.getValue()));
                }
            }
            gen += 1;
        }
    }
}