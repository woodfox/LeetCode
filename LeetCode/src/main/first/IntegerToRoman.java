package first;
import java.util.HashMap;

public class IntegerToRoman {
	public String intToRoman(int t) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
	        int[] v = {1, 5, 10, 50, 100, 500, 1000};
	        int[] prev = {0, 1, 1, 10, 10, 100, 100};
	        HashMap<Integer, Character> map = romanMap();
	        StringBuffer sb = new StringBuffer();
	        int i = v.length -1;
	        while(t > 0){
	            if(t < v[i]){
	                if(t >= v[i] - prev[i]){
	                    sb.append(map.get(prev[i]));
	                    sb.append(map.get(v[i]));
	                    t = t - v[i] + prev[i];
	                }
	                i--;
	            }else{
	                sb.append(map.get(v[i]));
	                t = t - v[i];
	            }
	        }
	        return sb.toString();
	    }

	HashMap<Integer, Character> romanMap(){
	        HashMap<Integer, Character> map = new HashMap<Integer, Character>();
	        map.put(1, 'I');
	        map.put(5, 'V');
	        map.put(10, 'X');
	        map.put(50, 'L');
	        map.put(100, 'C');
	        map.put(500, 'D');
	        map.put(1000, 'M');
	        return map;
	    }
}
