import java.io.*;
import java.math.*;
import java.util.*;

public class Solution1 {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new File("best_seller.dat"));
        ArrayList<Item> l = new ArrayList<Item>();
        while(in.hasNextLine()){
            String[] s = in.nextLine().split(",");
            l.add(new Item(s[0],new BigInteger(s[1]),Double.parseDouble(s[2].substring(1))));
        }
    }
}

class Item implements Comparable<Item>{

    String name;
    BigInteger sales;
    double numsales;

    public Item(String n, BigInteger i, double s){
        name = n;
        sales = i;
        numsales = s;
    }

    public int compareTo(Item o){
        return 1;
    }

    /*public String toString() {
        return String.format("$%.2f - %s/%s\n",sales.multiply().,name,sales.toString());
    }*/
}