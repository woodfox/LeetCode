package first;
import java.util.ArrayList;
import java.util.Arrays;

public class PascalTriangleII {
	public ArrayList<Integer> getRow(int k) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
	        ArrayList<Integer> result = new ArrayList<Integer>();
	        Integer[] prev = new Integer[k+1];
	        Integer[] next = new Integer[k+1];
	        prev[0] = 1;
	        if(k == 0){
	            result.addAll(Arrays.asList(prev));
	            return result;
	        }
	        next[0] = 1;
	        next[1] = 1;
	        if(k == 1){
	            result.addAll(Arrays.asList(next));
	            return result;
	        }
	        
	        Integer[] current = null;
	        Integer[] hist = null;
	        for(int i=2;i<=k;i++){
	            if(i%2 == 0){
	                current = prev;
	                hist = next;
	            }else{
	                current = next;
	                hist = prev;
	            }
	            current[0] = 1;
	            for(int j=1;j<i;j++){
	                current[j] = hist[j-1] + hist[j];
	            }
	            current[i] = 1;
	        }
	        result.addAll(Arrays.asList(current));
	        return result;
	    }
}
