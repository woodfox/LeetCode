package other;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithTwoChar {
    public int longestWithTWoChar(String s) {
        Map<Character, Integer> map = new HashMap();
        int n = s.length();
        int len = 0;
        int start = 0;
        int end = 0;

        while(end < n) {
            while(end < n) {
                char c = s.charAt(end);
                if(map.containsKey(c)) {
                    map.put(c, map.get(c)+1);
                }else if(map.size() < 2) {
                    map.put(c, 1);
                } else {
                    break;
                }
                end++;
            }

            len = Math.max(len, end-start);

            // Move start to right
            char c = s.charAt(start++);
            if(map.get(c) == 1) {
                map.remove(c);
            }else {
                map.put(c, map.get(c)-1);
            }
        }

        return len;
    }
}
