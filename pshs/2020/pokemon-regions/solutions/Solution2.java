
/**
 * @author Shakeel Samsudeen
 */

import java.io.*;
import java.util.*;

public class Solution2 {

    private static enum Region {
        KANTO, JOHTO, HOENN, SINNOH
    };

    public static void main(String args[]) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int n = Integer.parseInt(in.readLine());
        ArrayList<Pokemon> pokemon = new ArrayList<Pokemon>();
        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int num = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            pokemon.add(new Pokemon(name, num));
        }
        Collections.sort(pokemon);
        if (!pokemon.isEmpty() && pokemon.get(0).r == Region.KANTO)
            out.println("Kanto:");
        while (!pokemon.isEmpty() && pokemon.get(0).r == Region.KANTO) {
            out.println(pokemon.get(0));
            pokemon.remove(0);
        }
        if (!pokemon.isEmpty() && pokemon.get(0).r == Region.JOHTO)
            out.println("Johto:");
        while (!pokemon.isEmpty() && pokemon.get(0).r == Region.JOHTO) {
            out.println(pokemon.get(0));
            pokemon.remove(0);
        }
        if (!pokemon.isEmpty() && pokemon.get(0).r == Region.HOENN)
            out.println("Hoenn:");
        while (!pokemon.isEmpty() && pokemon.get(0).r == Region.HOENN) {
            out.println(pokemon.get(0));
            pokemon.remove(0);
        }
        if (!pokemon.isEmpty() && pokemon.get(0).r == Region.SINNOH)
            out.println("Sinnoh:");
        while (!pokemon.isEmpty() && pokemon.get(0).r == Region.SINNOH) {
            out.println(pokemon.get(0));
            pokemon.remove(0);
        }
        out.close();
    }

    private static class Pokemon implements Comparable<Pokemon> {
        Region r;
        String name;
        int num;

        public Pokemon(String name, int num) {
            if (num <= 151)
                r = Region.KANTO;
            else if (num <= 251)
                r = Region.JOHTO;
            else if (num <= 386)
                r = Region.HOENN;
            else if (num <= 493)
                r = Region.SINNOH;
            this.name = name;
            this.num = num;
        }

        public int compareTo(Pokemon p) {
            return num - p.num;
        }

        public String toString() {
            return String.format("%03d", num) + " " + name;
        }
    }
}