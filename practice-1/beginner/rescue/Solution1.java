import java.util.*;
import java.io.*;

public class Solution1 {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int maw = in.nextInt();
        int strange = in.nextInt();
        int stark = in.nextInt();
        int spiderman = in.nextInt();
        int together = strange + stark + spiderman;
        if (together < maw)
            System.out.println("The time stone is lost!");
        else if (together > maw * 2)
            System.out.println("Aiee!");
        else
            System.out.println("We win!");
    }
}