package third;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        LinkedList<String> wordQueue = new LinkedList<String>();
        LinkedList<Integer> depthQueue = new LinkedList<Integer>();

        wordList.add(endWord);

        wordQueue.add(beginWord);
        depthQueue.add(1);

        // Need to remove beginWord so that it will not be accessed later
        wordList.remove(beginWord);

        while(!wordQueue.isEmpty()) {
            String word = wordQueue.removeFirst();
            int depth = depthQueue.removeFirst();

            if(word.equals(endWord)) {
                return depth;
            } else {
                for(String next : transform(word, wordList)) {
                    wordQueue.add(next);
                    depthQueue.add(depth+1);

                    // Remove next from wordList immediately so that it will not be visited again (even in same level)
                    wordList.remove(next);
                }
            }
        }

        return 0;
    }

    private Set<String> transform(String s, Set<String> wordList) {
        Set<String> result = new HashSet<String>();

        StringBuffer sb = new StringBuffer(s);
        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);

            for(char d='a';d<='z';d++) {
                if(c == d) continue;

                sb.setCharAt(i, d);
                String t = sb.toString();
                if(wordList.contains(t)) {
                    result.add(t);
                }
            }

            // Restore character
            sb.setCharAt(i, c);
        }

        return result;
    }
}
