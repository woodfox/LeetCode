package third;

import java.util.*;

/**
 * There is a new alien language which uses the latin alphabet. However, the order among letters are unknown to you. You receive a list of words from the dictionary, wherewords are sorted lexicographically by the rules of this new language. Derive the order of letters in this language.

 For example,
 Given the following words in dictionary,

 [
 "wrt",
 "wrf",
 "er",
 "ett",
 "rftt"
 ]
 The correct order is: "wertf".

 Note:

 You may assume all letters are in lowercase.
 If the order is invalid, return an empty string.
 There may be multiple valid order of letters, return any one of them is fine.
 */
public class AlienGraph {
    /**
     * Build the graph by comparing two strings in the list; and use topological sort to get the order.
     *
     * Be careful:
     *   1. Do not miss characters without any in-degree
     *   2. Use Set instead of List for children to avoid adding duplicate edges.
     */
    public String alienOrder(List<String> l){
        Map<Character, Node> map = buildGraph(l);
        LinkedList<Node> q = new LinkedList();
        for(Node node : map.values()) {
            if(node.degree == 0) q.add(node);
        }

        StringBuffer sb = new StringBuffer();
        while(!q.isEmpty()) {
            Node node = q.remove();
            sb.append(node.c);

            for(Node c : node.child) {
                c.degree--;
                if(c.degree == 0) q.add(c);
            }
        }

        return sb.toString();
    }

    private Map<Character, Node> buildGraph(List<String> l) {
        Map<Character, Node> map = new HashMap();
        // initialize all nodes
        for(String s : l) {
            for(char c : s.toCharArray()) {
                if(!map.containsKey(c)) map.put(c, new Node(c));
            }
        }

        for(int i=0;i<l.size()-1;i++){
            String cur = l.get(i);
            String next = l.get(i+1);
            int p = 0;
            while(p < cur.length() && p < next.length() && cur.charAt(p) == next.charAt(p)) {
                p++;
            }
            if(p < cur.length()) {
                char c = cur.charAt(p);
                char d = next.charAt(p);
                Node node1 = map.get(c);
                Node node2 = map.get(d);

                // Avoid adding duplicate edges
                if(!node1.child.contains(node2)) {
                    node1.child.add(node2);
                    node2.degree++;
                }
            }
        }

        return map;
    }

    private class Node {
        char c;
        Set<Node> child = new HashSet();
        int degree = 0;

        public Node(char d) {
            c = d;
        }
    }
}
