import java.io.*;
import java.util.*;

public class Solution1 {
    static Scanner sc, in;
    static PrintWriter out;
    static int key;
    static ArrayList<Integer> list;

    public static void main(String[] args) throws Exception {
        sc = in = new Scanner(System.in);
        out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        sc.useDelimiter("[()\\s{,}]+");
        while (sc.hasNextLine()) {
            key = Integer.parseInt(sc.next());
            String line = sc.nextLine();
            Scanner nums = new Scanner(line);
            nums.useDelimiter("[()\\s{,}]+");
            list = new ArrayList<>();
            while (nums.hasNext())
                list.add(Integer.parseInt(nums.next()));
            int lcount = lin();
            int bcount = bin();
            out.println("B-" + bcount + " / L-" + lcount);
        }
        out.close();
    }

    static int lin() {
        int count = 0;
        for (int x = 0; x < list.size(); x++) {
            count++;
            if (list.get(x) == key)
                return count;
        }
        return count;
    }

    static int bin() {
        int count = 0;
        int lo = 0;
        int hi = list.size() - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            count++;
            if (list.get(mid) == key)
                return count;
            if (list.get(mid) < key)
                lo = mid + 1;
            else
                hi = mid - 1;
        }
        return count;
    }
}