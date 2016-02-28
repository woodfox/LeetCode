package third;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

 Find all strobogrammatic numbers that are of length = n.

 For example,

 Given n = 2, return ["11","69","88","96"].
 */
public class StrobogrammaticNumberII {
    /**
     * Time: O(5^(n/2))
     */
    public List<String> findStrobogrammatic(int n) {
        List<String> r = new ArrayList<String>();
        if(n == 0) {
            return r;
        } else if(n == 1) {
            for(char c : getMap().keySet()) {
                r.add("" + c);
            }
            return r;
        }

        StringBuffer sb = new StringBuffer();
        backtrack(n, sb, r, getMap());
        return r;
    }

    void backtrack(int n, StringBuffer sb, List<String> r, Map<Character, Character> map) {
        if(sb.length() >= (n+1)/2) {
            StringBuffer tmp = new StringBuffer(sb);
            for(int i=n/2-1;i>=0;i--){
                char c = sb.charAt(i);
                tmp.append(map.get(c));
            }
            r.add(tmp.toString());
        } else {
            for(char x : map.keySet()) {
                if(n%2 > 0 && sb.length() == n/2 && map.get(x) != x) {
                    continue;
                }
                if(sb.length() == 0 && x == '0') {
                    continue;
                }
                sb.append(x);
                backtrack(n, sb, r, map);
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }

    Map<Character, Character> getMap() {
        Map<Character, Character> map = new HashMap<Character, Character>();
        map.put('1', '1');
        map.put('0', '0');
        map.put('6', '9');
        map.put('9', '6');
        map.put('8', '8');
        return map;
    }

}
