
/**
 * @author JB Ladera
 */

import java.util.HashSet;
import java.util.Scanner;

public class Solution1 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Trie trie = new Trie();
        HashSet<String> set = new HashSet<>();
        int n = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        while (a-- > 0)
            set.add(sc.next());
        for (String s : set)
            trie.insert(s, true);
        set.clear();
        while (b-- > 0)
            set.add(sc.next());
        for (String s : set)
            trie.insert(s, false);
        while (n-- > 0)
            System.out.println(trie.search(sc.next()));
    }

    private static class Trie {
        Node root = new Node();

        class Node {
            Node[] arr;
            int a, b;

            public Node() {
                arr = new Node[26];
            }
        }

        public void insert(String s, boolean ash) {
            Node cur = root;
            for (int x = 0; x < s.length(); x++) {
                char c = s.charAt(x);
                int i = c - 'a';
                if (cur.arr[i] == null)
                    cur.arr[i] = new Node();
                cur = cur.arr[i];
                if (ash)
                    cur.a++;
                else
                    cur.b++;
            }
        }

        public String search(String s) {
            Node cur = root;
            for (int x = 0; x < s.length(); x++) {
                char c = s.charAt(x);
                int i = c - 'a';
                if (cur.arr[i] == null)
                    return "neither";
                cur = cur.arr[i];
            }
            if (cur.a == cur.b)
                return "neither";
            return cur.a > cur.b ? "Ash" : "Brock";
        }
    }
}