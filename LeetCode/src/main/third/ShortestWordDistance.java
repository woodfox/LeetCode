package third;

import java.util.List;

/**
 * Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.

 For example, Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

 Given word1 = "coding", word2 = "practice", return 3. Given word1 = "makes", word2 = "coding", return 1.

 Note
 You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.
 */
public class ShortestWordDistance {
    /**
     * Time: O(n)
     */
    int shortestDistance(List<String> l, String s, String t) {
        int pos1 = -1;
        int pos2 = -1;
        int dist = Integer.MAX_VALUE;
        for(int i=0;i<l.size();i++) {
            if(s.equals(l.get(i))) {
                pos1 = i;
            }
            if(t.equals(l.get(i))) {
                pos2 = i;
            }
            if(pos1 >= 0 && pos2 >= 0) {
                dist = Math.min(dist, Math.abs(pos2-pos1));
            }
        }

        return dist;
    }
}
