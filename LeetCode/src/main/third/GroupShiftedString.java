package third;

import java.util.*;

/**
 * Given a string, we can “shift” each of its letter to its successive letter, for example: “abc” -> “bcd”. We can keep “shifting” which forms the sequence:

 "abc" -> "bcd" -> ... -> "xyz" Given a list of strings which contains only lowercase alphabets, group all strings that belong to the same shifting sequence.

 For example,

 given: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"], Return:

 [ ["abc","bcd","xyz"], ["az","ba"], ["acef"], ["a","z"] ]

 Note
 For the return value, each inner list’s elements must follow the lexicographic order.
 */
public class GroupShiftedString {
    /**
     * Calculate unique difference string between characters in the string, and find similar strings
     *
     * Time: O(m*n)
     */
    List<List<String>> groupStrings(List<String> l) {
        List<List<String>> r = new ArrayList();
        Map<String, List<String>> map = new HashMap();

        for(String s : l) {
            String t = shift(s);
            List<String> sub = map.get(t);
            if(sub == null) {
                sub = new ArrayList();
                map.put(t, sub);
            }
            sub.add(s);
        }

        for(List<String> sub : map.values()) {
            Collections.sort(sub);
            r.add(sub);
        }
        return r;
    }

    private String shift(String s) {
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<s.length()-1;i++) {
            int diff = s.charAt(i+1) - s.charAt(i);
            if(diff < 0)  diff += 26;
            sb.append(diff + ",");
        }
        return sb.toString();
    }

    /**
     * Use HashSet to record if it's shifted string.
     * Should not have duplicated string in the list; otherwise needs to use HashMap to save the count.
     *
     * Time: O(26*m*n), m is average length of string, n is string count.
     */
    List<List<String>> groupStrings_slow(List<String> l) {
        List<List<String>> r = new ArrayList();
        Set<String> set = new HashSet(l);
        for(String s : l) {
            if(set.contains(s)) {
                List<String> sub = new ArrayList();

                for(int i=0;i<26;i++) {
                    StringBuffer sb = new StringBuffer(s);
                    for(int j=0;j<s.length();j++) {
                        char c = sb.charAt(j);
                        if(c + i <= 'z') {
                            c = (char)(c + i);
                        } else {
                            c = (char)('a' + c + i - 'z' - 1);
                        }
                        sb.setCharAt(j, c);
                    }
                    if(set.contains(sb.toString())) {
                        sub.add(sb.toString());
                        set.remove(sb.toString());
                    }
                }

                Collections.sort(sub);
                r.add(sub);
            }
        }

        return r;
    }
}
