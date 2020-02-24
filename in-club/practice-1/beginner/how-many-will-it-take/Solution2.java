import java.util.*;
import java.io.*;

/* 
Because the energy shield is constant and each attacker dissipates 100 MW,
you can say that if there are ≥ 13 attackers (1300 MW dissipation), 
they break the shield.
 */
public class Solution2 {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int attackers = in.nextInt();
        if (attackers >= 13)
            System.out.println("They've broken through!");
        else
            System.out.println("All is well.");
    }
}