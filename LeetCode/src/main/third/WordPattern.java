package third;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given a pattern and a string str, find if str follows the same pattern.

 Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

 Examples:
 pattern = "abba", str = "dog cat cat dog" should return true.
 pattern = "abba", str = "dog cat cat fish" should return false.
 pattern = "aaaa", str = "dog cat cat dog" should return false.
 pattern = "abba", str = "dog dog dog dog" should return false.
 Notes:
 You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.
 */
public class WordPattern {
    /**
     * Use Map (char -> string) and set(string) to make sure one-to-one mapping between patten and string.
     *
     * Time: O(n)
     */
    public boolean wordPattern(String p, String s) {
        Map<Character, String> map = new HashMap();
        Set<String> set = new HashSet();

        String[] a = s.split(" ");
        if(p.length() != a.length) return false;

        for(int i=0;i<p.length();i++) {
            char c = p.charAt(i);
            String t = a[i];
            if(!map.containsKey(c)) {
                if(set.contains(t)) {
                    return false;
                }

                set.add(t);
                map.put(c, t);
            } else {
                if(!t.equals(map.get(c))) {
                    return false;
                }
            }
        }

        return true;
    }
}
