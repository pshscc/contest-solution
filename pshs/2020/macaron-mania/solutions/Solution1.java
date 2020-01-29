
/**
 * @author JB Ladera
 */

import java.util.*;

public class Solution1 {
    private static int MAX = (int) 1e5;
    private static int[] bit = new int[MAX + 1];

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Customer[] arrive = new Customer[n], leave = new Customer[n];
        int[] ans = new int[n];
        for (int x = 0; x < n; x++)
            arrive[x] = leave[x] = new Customer(sc.nextInt(), sc.nextInt(), sc.nextInt(), x);
        Arrays.sort(arrive);
        Arrays.sort(leave, (a, b) -> a.w - b.w);
        for (int x = 0, li = 0; x < n;) {
            ArrayList<Customer> enter = new ArrayList<>();
            int t = arrive[x].t;
            while (li < n && leave[li].w <= t)
                update(leave[li++].p, -1);
            enter.add(arrive[x]);
            int xi = x + 1;
            while (xi < n && t == arrive[xi].t)
                enter.add(arrive[xi++]);
            for (Customer cur : enter) {
                update(cur.p, 1);
                ans[cur.i] = query(MAX) - query(cur.p);
            }
            x = xi;
        }
        for (int x = 0; x < n; x++)
            System.out.println(ans[x]);
    }

    private static void update(int i, int val) {
        for (; i <= MAX; i += i & -i)
            bit[i] += val;
    }

    private static int query(int i) {
        int sum = 0;
        for (; i > 0; i -= i & -i)
            sum += bit[i];
        return sum;
    }

    private static class Customer implements Comparable<Customer> {
        int t, w, p, i;

        public Customer(int a, int b, int c, int d) {
            t = a;
            w = b + t;
            p = c;
            i = d;
        }

        public int compareTo(Customer other) {
            if (t == other.t)
                return other.p - p;
            return t - other.t;
        }
    }
}