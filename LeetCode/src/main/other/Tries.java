package other;

import java.util.HashMap;
import java.util.Map;

public class Tries {
    class Node {
        char c;
        boolean isLeaf = false;
        Map<Character, Node> map = new HashMap<Character, Node>();

        public Node(char d) {
            this.c = d;
        }
    }

    private Node root = new Node(' ');

    public void add(String s) {
        if(s != null) {
            insert(root, s);
        }
    }

    private void insert(Node node, String s) {
        if(s.length() > 0) {
            char c = s.charAt(0);
            Node child = node.map.get(c);
            if(child == null) {
                child = new Node(c);
                node.map.put(c, child);
            }
            insert(child, s.substring(1));
        } else {
            node.isLeaf = true;
        }
    }

    public boolean contains(String s) {
        if(s == null) {
            return false;
        } else {
            return checkNode(root, s);
        }
    }

    private boolean checkNode(Node node, String s){
        if(s.length() == 0) {
            return node.isLeaf;
        } else {
            Node child = node.map.get(s.charAt(0));
            if(child == null) {
                return false;
            } else {
                return checkNode(child, s.substring(1));
            }
        }
    }
}
