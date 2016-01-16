package second;

import java.util.HashMap;

public class RomanToInt {
    public int romanToInt(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

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
    
	//TLE error!
    public int romanToInt2(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        int n = s.length();
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        
        int r = 0;
        for(int i=0;i<n;i++){
            char c = s.charAt(i);
            int x = map.get(c);
            if(i < n-1){
                char d = s.charAt(i+1);
                int y = map.get(d);
                if(x < y){
                    x = y-x;
                    i++;
                }
            }
            r += x;
        }
        return r;
    }
    
    public static void main(String[] args){
    	RomanToInt r = new RomanToInt();
    	System.out.println(r.romanToInt("MMMDLXXXVI"));
    }
}
