package third;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

 Write a function to count the total strobogrammatic numbers that exist in the range of low <= num <= high.

 For example,

 Given low = "50", high = "100", return 3. Because 69, 88, and 96 are three strobogrammatic numbers.

 Note:

 Because the range might be a large number, the low and high numbers are represented as string.
 */
public class StrobogrammaticNumberIII {
    /**
     * Find all strobogrammatic numbers between low and high length, and filter numbers
     * which is less than low or greater than high.
     */
    public int strobogrammaticInRange(String low, String high) {
        int m = low.length();
        int n = high.length();
        List<String> r = new ArrayList<String>();
        for(int i=m;i<=n;i++) {
            r.addAll(findStrobogrammatic(i));
        }

        int total = r.size();
        for(String s : r) {
            if(s.length() == m && s.compareTo(low) < 0) {
                total--;
            } else if(s.length() == n && s.compareTo(high) > 0) {
                total--;
            }
        }

        return total;
    }

    private List<String> findStrobogrammatic(int n) {
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

    private void backtrack(int n, StringBuffer sb, List<String> r, Map<Character, Character> map) {
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
