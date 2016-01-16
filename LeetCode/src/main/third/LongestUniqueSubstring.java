package third;

import java.util.HashMap;

public class LongestUniqueSubstring {

    public int lengthOfLongestSubstring(String s) {
        char[] array = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int maxLength = 0;
        int start = 0;
        int end = 0;
        while(end < array.length) {
            Integer pos = map.get(array[end]);
            if(pos != null) {
                for(int i=start;i<=pos;i++){
                    map.put(array[i], null);
                }
                start = pos + 1;
            }
            map.put(array[end], end);
            end++;
            maxLength = Math.max(maxLength, end - start);
        }

        return maxLength;
    }
}
