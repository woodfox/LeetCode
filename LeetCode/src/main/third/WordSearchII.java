package third;

import java.util.*;

/**
 * Given a 2D board and a list of words from the dictionary, find all words in the board.

 Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.

 For example,
 Given words = ["oath","pea","eat","rain"] and board =

 [
 ['o','a','a','n'],
 ['e','t','a','e'],
 ['i','h','k','r'],
 ['i','f','l','v']
 ]
 Return ["eat","oath"].
 */
public class WordSearchII {
    public List<String> findWords(char[][] board, String[] words) {
        Trie t = new Trie();
        for(String w:words) {
            t.insert(w);
        }

        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        StringBuffer sb = new StringBuffer();
        Set<String> set = new HashSet<String>();

        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                backtrack(board, i, j, visited, sb, t, set);
            }
        }

        return new ArrayList(set);
    }

    private void backtrack(char[][] b, int row, int col, boolean[][] visited, StringBuffer sb, Trie t, Set<String> set) {
        int m = b.length;
        int n = b[0].length;
        if(row < 0 || row >= m || col < 0 || col >= n || visited[row][col]) {
            return;
        }
        // If no words start with this path, just abort it
        if(!t.startsWith(sb.toString() + b[row][col])) {
            return;
        }

        sb.append(b[row][col]);
        visited[row][col] = true;

        // If words found in the path, add it into result set
        if(t.search(sb.toString())) {
            set.add(sb.toString());
        }

        backtrack(b, row+1, col, visited, sb, t, set);
        backtrack(b, row-1, col, visited, sb, t, set);
        backtrack(b, row, col+1, visited, sb, t, set);
        backtrack(b, row, col-1, visited, sb, t, set);

        sb.deleteCharAt(sb.length()-1);
        visited[row][col] = false;
    }

    //---------------------------------------
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
}
