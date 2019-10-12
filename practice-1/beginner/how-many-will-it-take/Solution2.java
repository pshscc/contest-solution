import java.util.*;
import java.io.*;

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