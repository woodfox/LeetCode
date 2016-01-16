package third;

import java.util.HashMap;

public class RomanToInteger {
    public int romanToInt(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }

        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        //'I', 'V', 'X', 'L', 'C', 'D', 'M'
        map.put('~', 0);
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int result = 0;
        int n = s.length();
        for(int i=0;i<n;i++){
            char c = s.charAt(i);
            char next = '~';
            if(i < n-1) {
                next = s.charAt(i+1);
            }
            if(map.get(c) < map.get(next)) {
                result += map.get(next) - map.get(c);
                i++;
            }else{
                result += map.get(c);
            }
        }

        return result;
    }
}
