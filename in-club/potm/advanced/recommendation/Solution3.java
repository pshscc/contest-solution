
/**
 * @author Travis Dula
 */

import java.io.*;
import java.util.*;

public class Solution3 {
    static BufferedReader in;
    static PrintWriter out;
    static StringTokenizer st;
    static Iterator<String> iter;

    public static void main(String[] args) throws Exception {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        int m = Integer.parseInt(in.readLine());
        String[] members = in.readLine().split(" ");
        Map<String, Set<String>> map = new HashMap<String, Set<String>>();
        for (int i = 0; i < m; i++) {
            map.put(members[i], new HashSet<String>());
            st = new StringTokenizer(in.readLine());
            st.nextToken();
            while (st.hasMoreTokens()) {
                map.get(members[i]).add(st.nextToken());
            }
        }
        Queue<String> queue;
        int t = Integer.parseInt(in.readLine());
        String source;
        String friend;
        while (t-- > 0) {
            source = in.readLine();
            Set<String> visited = new HashSet<String>();
            visited.add(source);
            queue = new ArrayDeque<String>();
            iter = map.get(source).iterator();
            queue.offer(source);
            int d = 0, x = 1, xMax = x, dFirst = 1;
            while (!queue.isEmpty()) {
                x = queue.size();
                if (x > xMax) {
                    xMax = x;
                    dFirst = d;
                }
                d++;
                while (x-- > 0) {
                    iter = map.get(queue.poll()).iterator();
                    while (iter.hasNext()) {
                        friend = iter.next();
                        if (!visited.contains(friend)) {
                            visited.add(friend);
                            queue.offer(friend);
                        }
                    }
                }

            }
            if (x > xMax) {
                d--;
                xMax = x;
                dFirst = d;
            }
            if (visited.size() < members.length)
                d = -1;
            if (visited.size() > 1)
                out.println(dFirst + " " + xMax + " " + d);
            else
                out.println(0);
        }
        out.close();
    }
}