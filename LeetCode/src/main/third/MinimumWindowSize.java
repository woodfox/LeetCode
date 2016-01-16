package third;

import java.util.HashMap;
import java.util.Map;

// O(n)
public class MinimumWindowSize {
    public String minWindow(String s, String t) {
        if(s == null || t == null || t.length() == 0) return "";

        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for(char c : t.toCharArray()) {
            Integer count = map.get(c);
            if(count == null) count = 0;
            map.put(c, count + 1);
        }

        int minLength = Integer.MAX_VALUE;
        String result = "";
        int start = 0;
        int end = 0;
        while(end < s.length()) {
            char c = s.charAt(end);
            if(map.containsKey(c)){
                map.put(c, map.get(c) - 1);
            }

            if(hasAll(map)){
                // Move Start
                while(start <= end){
                    char d = s.charAt(start);
                    Integer count = map.get(d);
                    if(count != null && count < 0) {
                        map.put(d, count + 1);
                    }else if(count != null){
                        break;
                    }
                    start++;
                }
                if((end-start+1) < minLength) {
                    minLength = Math.min(minLength, (end - start + 1));
                    result = s.substring(start, end+1);
                }
            }

            // Move end
            end++;
        }

        return result;
    }

    boolean hasAll(Map<Character, Integer> map) {
        for(char c : map.keySet()){
            if(map.get(c) > 0) return false;
        }
        return true;
    }
}
