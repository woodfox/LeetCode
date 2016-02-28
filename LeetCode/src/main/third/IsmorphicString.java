package third;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given two strings s and t, determine if they are isomorphic.

 Two strings are isomorphic if the characters in s can be replaced to get t.

 All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.

 For example,
 Given "egg", "add", return true.

 Given "foo", "bar", return false.

 Given "paper", "title", return true.
 */
public class IsmorphicString {
    public boolean isIsomorphic(String s, String t) {
        if(s == null || t == null || s.length() != t.length()) {
            return false;
        }
        Map<Character, Character> map1 = new HashMap();
        Map<Character, Character> map2 = new HashMap();
        for(int i=0;i<s.length();i++) {
            char c=  s.charAt(i);
            char d = t.charAt(i);
            if(!map1.containsKey(c)) {
                map1.put(c, d);
            }
            if(!map2.containsKey(d)) {
                map2.put(d, c);
            }

            if(map1.get(c) != d || map2.get(d) != c) {
                return false;
            }
        }
        return true;
    }
}
