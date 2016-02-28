package third;

import java.util.HashMap;
import java.util.Map;

/**
 * Design a data structure that supports the following two operations:

 void addWord(word)
 bool search(word)
 search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.

 For example:

 addWord("bad")
 addWord("dad")
 addWord("mad")
 search("pad") -> false
 search("bad") -> true
 search(".ad") -> true
 search("b..") -> true
 */
class WordDictionary {
    /**
     * Use Tries to match words quickly.
     *
     * Time: O(m*n) in worst case, m is length of word
     */
    class Node {
        boolean isLeaf = false;
        Map<Character, Node> children = new HashMap();
    }

    Node root = new Node();

    // Adds a word into the data structure.
    public void addWord(String word) {
        if(word != null) {
            addNode(root, word);
        }
    }

    private void addNode(Node root, String word) {
        if(word.length() == 0) {
            root.isLeaf = true;
        } else {
            char c = word.charAt(0);
            Node node = root.children.get(c);
            if(node == null) {
                node = new Node();
                root.children.put(c, node);
            }
            addNode(node, word.substring(1));
        }
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        if(word != null) {
            return searchNode(root, word);
        } else {
            return false;
        }
    }

    private boolean searchNode(Node root, String word) {
        if(word.length() == 0) {
            return root.isLeaf;
        } else {
            char c = word.charAt(0);
            if(c != '.') {
                Node node = root.children.get(c);
                if(node == null) {
                    return false;
                } else {
                    return searchNode(node, word.substring(1));
                }
            } else {
                // . match any characters
                for(Node node : root.children.values()) {
                    if(searchNode(node, word.substring(1))) {
                        return true;
                    }
                }
                return false;
            }
        }
    }
}