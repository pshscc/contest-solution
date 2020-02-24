import java.util.*;
import java.io.*;

/* 
In this explanation I will refer to the sum of strange's, stark's, and
spiderman's strength as T and maw's strength as M.

The only thing to watch out for is the order when creating your if statements
are the cases T > M * 2 and T > M because if T > M * 2 is true,
then T > M is also true. Therefore, you must check T > M * 2 first.
 */
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