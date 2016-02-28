package third;

import java.util.HashMap;
import java.util.Map;

/**
 * Implement a trie with insert, search, and startsWith methods.

 Note:
 You may assume that all inputs are consist of lowercase letters a-z
 */
class TrieNode {
    // Initialize your data structure here.
    boolean isLeaf = false;
    Map<Character, TrieNode> children = new HashMap();

    public TrieNode() {
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        if(word != null) {
            insertNode(root, word);
        }
    }

    private void insertNode(TrieNode root, String word) {
        if(word.length() == 0) {
            root.isLeaf = true;
            return;
        }

        char c = word.charAt(0);
        TrieNode child = root.children.get(c);
        if(child == null) {
            child = new TrieNode();
            root.children.put(c, child);
        }

        insertNode(child, word.substring(1));
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        if(word != null) {
            return searchNode(root, word, true);
        } else {
            return false;
        }
    }

    private boolean searchNode(TrieNode root, String word, boolean onlyLeaf) {
        if(word.length() == 0) {
            if(onlyLeaf) {
                return root.isLeaf;
            } else {
                return true;
            }
        } else {
            char c = word.charAt(0);
            TrieNode child = root.children.get(c);
            if(child == null) {
                return false;
            } else {
                return searchNode(child, word.substring(1), onlyLeaf);
            }
        }
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String word) {
        if(word != null) {
            return searchNode(root, word, false);
        } else {
            return false;
        }
    }
}
