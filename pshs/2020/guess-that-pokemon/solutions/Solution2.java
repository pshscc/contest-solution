
/**
 * @author Shakeel Samsudeen
 */

import java.io.*;
import java.util.*;

public class Solution2 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(in.readLine());

        int n = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        Node ash = new Node(' ');
        st = new StringTokenizer(in.readLine());
        while (a-- > 0) {
            insert(st.nextToken(), ash);
        }
        Node brock = new Node(' ');
        st = new StringTokenizer(in.readLine());
        while (b-- > 0) {
            insert(st.nextToken(), brock);
        }
        while (n-- > 0) {
            int countA = 0, countB = 0;
            String prefix = in.readLine();
            Node tempA = search(prefix, ash);
            Node tempB = search(prefix, brock);
            if (tempA != null)
                countA = count(tempA);
            if (tempB != null)
                countB = count(tempB);
            out.println(countA == countB ? "neither" : (countA > countB ? "Ash" : "Brock"));
        }
        out.close();
    }

    public static class Node {
        char c;
        boolean end;
        Node[] children;

        public Node(char c) {
            this.c = c;
            children = new Node[26];
        }
    }

    public static void insert(String s, Node root) {
        for (char c : s.toCharArray()) {
            if (root.children[(int) (c - 'a')] == null) {
                root.children[(int) (c - 'a')] = new Node(c);
            }
            root = root.children[(int) (c - 'a')];
        }
        root.end = true;
    }

    public static Node search(String s, Node root) {
        for (char c : s.toCharArray()) {
            if (root.children[(int) (c - 'a')] == null)
                return null;
            root = root.children[(int) (c - 'a')];
        }
        return root;
    }

    public static int count(Node root) {
        int count = 0;
        if (root.end)
            count++;
        for (int i = 0; i < root.children.length; i++) {
            if (root.children[i] != null)
                count += count(root.children[i]);
        }
        return count;
    }
}