package third;

import java.util.*;

public class Anagram {
    public List<List<String>> groupAnagrams(String[] strs) {
        Arrays.sort(strs);

        Map<String, List<String>> map = new HashMap();
        for(String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String t = new String(chars);
            if(!map.containsKey(t)) map.put(t, new ArrayList<String>());
            map.get(t).add(s);
        }

        return new ArrayList(map.values());
    }
}
