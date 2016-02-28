package third;

import java.util.*;

/**
 * Given a string s, return all the palindromic permutations (without duplicates) of it. Return an empty list if no palindromic permutation could be form.

 For example:

 Given s = "aabb", return ["abba", "baab"].

 Given s = "abc", return [].
 */
public class PalindromePermutationII {
    List<String> generatePalindromes(String s) {
        Map<Character, Integer> map = new HashMap();
        for(char c : s.toCharArray()) {
            if(!map.containsKey(c)) {
                map.put(c, 0);
            }
            map.put(c, map.get(c)+1);
        }
        Set<Character> odd = new HashSet();
        String oddStr = "";
        for(char c : map.keySet()){
            if(map.get(c)%2 == 1) {
                oddStr = ""+c;
                odd.add(c);
                map.put(c, map.get(c)-1);
            }
        }

        List<String> r = new ArrayList();
        int n = s.length();
        if((n%2 == 0 && odd.size() > 0) || (n%2 == 1 && odd.size() > 1)) {
            return r;
        }

        StringBuffer sb = new StringBuffer();
        backtrack(n, oddStr, map, sb, r);
        return r;
    }

    private void backtrack(int n, String odd, Map<Character, Integer> map, StringBuffer sb, List<String> r) {
        int l = sb.length();
        if(l*2 == n/2*2){
            StringBuffer reverse = new StringBuffer(sb);
            reverse.reverse();
            r.add(sb.toString() + odd + reverse.toString());
        } else {
            for(char c : map.keySet()) {
                if(map.get(c) > 0){
                    sb.append(c);
                    map.put(c, map.get(c)-2);

                    backtrack(n, odd, map, sb, r);

                    sb.deleteCharAt(sb.length()-1);
                    map.put(c, map.get(c)+2);
                }
            }
        }
    }
}
