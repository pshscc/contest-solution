/**
 * @author Shakeel Samsudeen
 * We can implement a simple BFS for this problem,
 * with a special Member class to easily maintain
 * our data and update our dates when members have
 * watched the recommended anime. 
 */

import java.io.*;
import java.util.*;

public class Solution1 {

    static int max = 0;
    static int day = 0;
    static int everyone = 0;
    static Member[] members;
    static HashMap<String, Integer> map;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int e = Integer.parseInt(in.readLine());
        members = new Member[e];        
        
        map = new HashMap<String, Integer>();
        StringTokenizer st = new StringTokenizer(in.readLine());
        for(int i = 0; i < e; i++) {
            String name = st.nextToken();
            map.put(name, i);
            members[i] = new Member(name, i);
        }

        for(int i = 0; i < e; i++) {
            st = new StringTokenizer(in.readLine());
            int n = Integer.parseInt(st.nextToken());
            for(int j = 0; j < n; j++) {
                members[i].friends.add(members[map.get(st.nextToken())]);
            }
        }

        int t = Integer.parseInt(in.readLine());
        while(t-- > 0) {
            String src = in.readLine();
            day = 0;
            max = 0;
            everyone = 0;
            bfs(members[map.get(src)]);
            if(day < 0) 
                out.println("0");
            else 
                out.println(day + " " + max + " " + everyone);
        }
        out.close();
    }
    
    public static void bfs(Member src) {
        HashSet<Integer> visited = new HashSet<Integer>();
        Queue<Member> queue = new LinkedList<Member>();
        queue.offer(src);
        src.x = 0;
        int[] days = new int[2600];
        while(!queue.isEmpty()) {
            Member u = queue.poll();
            if(visited.contains(u.i)) continue;
            visited.add(u.i);
            for(Member v : u.friends)  {
                if(!queue.contains(v) && !visited.contains(v.i)) {
                    v.x = u.x + 1;
                    queue.offer(v);
                }
            }
            days[u.x]++;
        }
        if(visited.size() == 1) day = -1;
        else {
            for(int i = 1; i < days.length; i++) {
                if(days[i] > max) {
                    day = i;
                    max = days[i];
                }
                if(days[i] > 0)
                    everyone = i;
            }
        }
        everyone = visited.size() == members.length ? everyone + 1 : -1;
    }
}

class Member {
    int i;
    String name;
    ArrayList<Member> friends;
    boolean visited;
    int x;

    public Member(String name, int i) {
        this.name = name;
        this.i = i;
        friends = new ArrayList<Member>();
        visited = false;
    }

    public String toString() {
        return i + "";
    }
}