package third;

import java.util.*;

public class Anagram {
    public List<String> anagrams(String[] strs) {
        List<String> result = new ArrayList<String>();
        Map<String, List<String>> map = new HashMap<String, List<String>>();

        for(String s: strs) {
            char[] array = s.toCharArray();
            Arrays.sort(array);
            String t = new String(array);
            List<String> list = new ArrayList<String>();
            if(map.containsKey(t)){
                list = map.get(t);
            }
            list.add(s);
            map.put(t, list);
        }

        for(List<String> sub : map.values()){
            if(sub.size() > 1) {
                result.addAll(sub);
            }
        }
        return result;
    }
}
