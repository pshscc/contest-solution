
/**
 * @author Shakeel Samsudeen
 */

import java.io.*;
import java.util.*;

public class Solution2 {
    static enum Stat {
        HEALTH, ATTACK, DEFENSE, SPECIAL_ATTACK, SPECIAL_DEFENSE, SPEED
    };

    public static void main(String args[]) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(in.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        TreeSet<Pokemon> health = new TreeSet<Pokemon>();
        TreeSet<Pokemon> attack = new TreeSet<Pokemon>();
        TreeSet<Pokemon> defense = new TreeSet<Pokemon>();
        TreeSet<Pokemon> specialAttack = new TreeSet<Pokemon>();
        TreeSet<Pokemon> specialDefense = new TreeSet<Pokemon>();
        TreeSet<Pokemon> speed = new TreeSet<Pokemon>();
        while (n-- > 0) {
            st = new StringTokenizer(in.readLine());
            String name = st.nextToken();
            long tHealth = Long.parseLong(st.nextToken());
            long tAttack = Long.parseLong(st.nextToken());
            long tDefense = Long.parseLong(st.nextToken());
            long tSpecialAttack = Long.parseLong(st.nextToken());
            long tSpecialDefense = Long.parseLong(st.nextToken());
            long tSpeed = Long.parseLong(st.nextToken());
            health.add(new Pokemon(Stat.HEALTH, name, tHealth, tAttack, tDefense, tSpecialAttack, tSpecialDefense,
                    tSpeed));
            attack.add(new Pokemon(Stat.ATTACK, name, tHealth, tAttack, tDefense, tSpecialAttack, tSpecialDefense,
                    tSpeed));
            defense.add(new Pokemon(Stat.DEFENSE, name, tHealth, tAttack, tDefense, tSpecialAttack, tSpecialDefense,
                    tSpeed));
            specialAttack.add(new Pokemon(Stat.SPECIAL_ATTACK, name, tHealth, tAttack, tDefense, tSpecialAttack,
                    tSpecialDefense, tSpeed));
            specialDefense.add(new Pokemon(Stat.SPECIAL_DEFENSE, name, tHealth, tAttack, tDefense, tSpecialAttack,
                    tSpecialDefense, tSpeed));
            speed.add(
                    new Pokemon(Stat.SPEED, name, tHealth, tAttack, tDefense, tSpecialAttack, tSpecialDefense, tSpeed));
        }
        TreeSet<Pokemon> remove = new TreeSet<Pokemon>();
        while (k-- > 0) {
            remove.add(health.pollFirst());
            remove.add(attack.pollFirst());
            remove.add(defense.pollFirst());
            remove.add(specialAttack.pollFirst());
            remove.add(specialDefense.pollFirst());
            remove.add(speed.pollFirst());
        }
        TreeSet<String> res = new TreeSet<String>();
        for (Pokemon p : remove) {
            res.add(p.name);
        }
        for (String s : res)
            out.println(s);
        out.close();
    }

    private static class Pokemon implements Comparable<Pokemon> {
        Stat s;
        String name;
        long health;
        long attack;
        long defense;
        long specialAttack;
        long specialDefense;
        long speed;

        public Pokemon(Stat s, String name, long health, long attack, long defense, long specialAttack,
                long specialDefense, long speed) {
            this.s = s;
            this.name = name;
            this.health = health;
            this.attack = attack;
            this.defense = defense;
            this.specialAttack = specialAttack;
            this.specialDefense = specialDefense;
            this.speed = speed;
        }

        public int compareTo(Pokemon p) {
            switch (s) {
            case HEALTH:
                return Long.compare(health, p.health);
            case ATTACK:
                return Long.compare(attack, p.attack);
            case DEFENSE:
                return Long.compare(defense, p.defense);
            case SPECIAL_ATTACK:
                return Long.compare(specialAttack, p.specialAttack);
            case SPECIAL_DEFENSE:
                return Long.compare(specialDefense, p.specialDefense);
            case SPEED:
                return Long.compare(speed, p.speed);
            }
            return 0;
        }

        public String toString() {
            return name;
        }
    }
}