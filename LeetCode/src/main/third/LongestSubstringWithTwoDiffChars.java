package third;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * Given a string S, find the length of the longest substring T that contains at most two distinct characters.
 * For example, Given S = “eceba”, T is `"ece" which its length is 3.
 */
public class LongestSubstringWithTwoDiffChars {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }

        int n = s.length();
        int start = 0;
        int end = 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        while(end < n) {
            // Extend end as much as possible
            while(end < n) {
                char c = s.charAt(end);
                if(map.containsKey(c) || map.size() < 2) {
                    Integer count = map.get(c);
                    if(count == null) {
                        count = 0;
                    }
                    count++;
                    map.put(c, count);
                    end++;
                } else {
                    break;
                }
            }

            max = Math.max(max, end-start);

            // Move start to right until there is only one character
            while(map.size() == 2) {
                char c = s.charAt(start);
                int count = map.get(c);
                count--;
                if(count == 0) {
                    map.remove(c);
                } else {
                    map.put(c, count);
                }
                start++;
            }
        }

        return max;
    }
}
