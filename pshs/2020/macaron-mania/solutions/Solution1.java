
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
        Customer[] arr = new Customer[n], wait = new Customer[n];
        int[] ans = new int[n];
        for (int x = 0; x < n; x++)
            arr[x] = wait[x] = new Customer(sc.nextInt(), sc.nextInt(), sc.nextInt(), x);
        Arrays.sort(arr);
        Arrays.sort(wait, (a, b) -> a.w - b.w);
        for (int x = 0, li = 0; x < n;) {
            ArrayList<Customer> enter = new ArrayList<>();
            int t = arr[x].t;
            while (li < n && wait[li].w <= t)
                update(wait[li++].p, -1);
            enter.add(arr[x]);
            int xi = x + 1;
            while (xi < n && t == arr[xi].t)
                enter.add(arr[xi++]);
            int count = xi - x - 1;
            for (Customer cur : enter) {
                update(cur.p, 1);
                ans[cur.i] = query(MAX) - query(cur.p) + count--;
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
                return p - other.p;
            return t - other.t;
        }
    }
}