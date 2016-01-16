package first;
import java.util.HashMap;

public class RomanToInteger {
    public int romanToInt(String s) {
		// Start typing your Java solution below
		// DO NOT write main() function
		HashMap<Character, Integer> map = romanMap();
		if (s.length() == 0) {
			return 0;
		}

		int r = 0;
		for(int i=0;i<s.length();i++){
    	    int current = map.get(s.charAt(i));
            int prev = current;
            if(i > 0){
                prev = map.get(s.charAt(i-1));
            }
            if(current > prev){
                r += current - 2 * prev;
            }else{
                r += current;
            }
		}
			
		return r;
	}

	HashMap<Character, Integer> romanMap() {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);
		return map;
	}
}