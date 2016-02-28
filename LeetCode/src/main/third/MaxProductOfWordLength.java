package third;

import java.util.*;

/**
 * Given a string array words, find the maximum value of length(word[i]) * length(word[j]) where the two words do not share common letters. You may assume that each word will contain only lower case letters. If no such two words exist, return 0.

 Example 1:
 Given ["abcw", "baz", "foo", "bar", "xtfn", "abcdef"]
 Return 16
 The two words can be "abcw", "xtfn".

 Example 2:
 Given ["a", "ab", "abc", "d", "cd", "bcd", "abcd"]
 Return 4
 The two words can be "ab", "cd".

 Example 3:
 Given ["a", "aa", "aaa", "aaaa"]
 Return 0
 No such pair of words.
 */
public class MaxProductOfWordLength {
    /**
     * Brute force but using bit manipulation to improve the performance.
     *
     * Time: O(n^2)
     */
    public int maxProduct(String[] words) {
        int max = 0;
        int n = words.length;
        Map<String, Integer> map = init(words);

        for(int i=0;i<n;i++){
            String s = words[i];
            for(int j=i+1;j<n;j++){
                String t = words[j];
                if(!hasCommon(s, t, map)) {
                    max = Math.max(max, s.length()*t.length());
                }
            }
        }
        return max;
    }

    // O(n*m) to init
    private Map<String, Integer> init(String[] words) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        for(String s:words) {
            int x = 0;
            for(char c : s.toCharArray()) {
                x |= (1 << (c-'a'));
            }
            map.put(s, x);
        }
        return map;
    }

    // O(1)
    private boolean hasCommon(String s, String t, Map<String, Integer> map) {
        int a = map.get(s);
        int b = map.get(t);
        return (a&b) > 0;
    }
}
