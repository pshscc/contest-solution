import java.util.*;
import java.io.*;

public class Solution1 {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int attackers = in.nextInt();
        int dissipation = attackers * 100;
        if (dissipation >= 1210)
            System.out.println("They've broken through!");
        else
            System.out.println("All is well.");
    }
}