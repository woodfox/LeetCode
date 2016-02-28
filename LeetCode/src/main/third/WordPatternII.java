package third;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given a pattern and a string str, find if str follows the same pattern.

 Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty substring in str.

 Examples:
 pattern = "abab", str = "redblueredblue" should return true.
 pattern = "aaaa", str = "asdasdasdasd" should return true.
 pattern = "aabb", str = "xyzabcxzyabc" should return false.
 Notes: You may assume both pattern and str contains only lowercase letters.
 */
public class WordPatternII {
    /**
     * Try all possibilities with backtrack.
     *
     * Time: O(n!)
     *
     * Be careful:
     *   1. Only need to remove from map when it's newly added!!
     */
    boolean isValid(String p, String s) {
        Map<Character, String> map = new HashMap();
        Set<String> set = new HashSet();
        return backtrack(p, s, 0, 0, set, map);
    }

    private boolean backtrack(String p, String s, int pos1, int pos2, Set<String> set, Map<Character, String> map) {
        int m = s.length();
        int n = p.length();
        if(pos1 == n) {
            // Reach the end
            return pos2 == m;
        } else {
            for(int i=pos2+1;i<=m;i++) {
                // For last element, needs to go to the end
                if(pos1 == n-1 && i!=m) {
                    continue;
                }

                String t = s.substring(pos2, i);
                char c = p.charAt(pos1);
                boolean flag = map.containsKey(c);
                if((flag && t.equals(map.get(c)))
                        || (!flag && !set.contains(t))) {
                    if(!flag) {
                        set.add(t);
                        map.put(c, t);
                    }

                    if(backtrack(p, s, pos1+1, i, set, map)) {
                        return true;
                    }

                    // Only need to remove the mapping if it's newly added!
                    if(!flag) {
                        set.remove(t);
                        map.remove(c);
                    }
                }
            }
            return false;
        }
    }
}
