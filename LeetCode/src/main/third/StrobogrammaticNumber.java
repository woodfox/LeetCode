package third;

import java.util.HashMap;
import java.util.Map;

/**
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

 Write a function to determine if a number is strobogrammatic. The number is represented as a string.

 For example, the numbers "69", "88", and "818" are all strobogrammatic.
 */
public class StrobogrammaticNumber {
    public boolean isStrobogrammatic(String s) {
        if(s == null) return true;
        Map<Integer, Integer> map = getMap();
        int l = 0;
        int r = s.length()-1;
        while(l <= r) {
            int a = s.charAt(l) - '0';
            int b = s.charAt(r) - '0';
            if(!map.containsKey(a) || map.get(a) != b) {
                return false;
            }
            l++;
            r--;
        }

        return true;
    }

    Map<Integer, Integer> getMap() {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(1, 1);
        map.put(0, 0);
        map.put(6, 9);
        map.put(9, 6);
        map.put(8, 8);
        return map;
    }

}
