package first;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class CombinationSumII {
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] a, int t) {
        // Start typing your Java solution below
        // DO NOT write main() function
        HashMap<Integer, Integer> count = getCount(a);
        
        HashSet<Integer> set = new HashSet<Integer>();
        for(int x:a){
        	set.add(x);
        }
        Integer[] b = new Integer[set.size()];
        set.toArray(b);
        Arrays.sort(b);
        
        ArrayList<Integer> sub = new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        backtrack(b, count, 0, t, 0, sub, result);
        return result;
    }
    
    void backtrack(Integer[] b, HashMap<Integer, Integer> count, int sum, int t, int pre, ArrayList<Integer> sub, ArrayList<ArrayList<Integer>> result){
        if(sum == t){
            addResult(sub, result);
        }else{
            ArrayList<Integer> c = getCandicates(b, count, sum, t, pre);
            for(int x:c){
                sub.add(b[x]);
                count.put(b[x], count.get(b[x])-1);
                backtrack(b, count, sum+b[x], t, x, sub, result);
                sub.remove(sub.size()-1);
                count.put(b[x], count.get(b[x])+1);
            }
        }
    }
    
    void addResult(ArrayList<Integer> sub, ArrayList<ArrayList<Integer>> result){
        ArrayList<Integer> dup = new ArrayList<Integer>(sub);
        result.add(dup);
    }
    
    ArrayList<Integer> getCandicates(Integer[] b, HashMap<Integer, Integer> count, int sum, int t, int pre){
        ArrayList<Integer> r = new ArrayList<Integer>();
        for(int i=pre;i<b.length;i++){
            if(count.get(b[i]) <= 0){
                continue;
            }
            if(sum + b[i] > t){
                break;
            }
            r.add(i);
        }
        return r;
    }
    
    HashMap<Integer, Integer> getCount(int[] a){
        HashMap<Integer, Integer> count = new HashMap<Integer, Integer>();
        for(int x:a){
            Integer c = count.get(x);
            if(c == null){
                c = 0;
            }
            count.put(x, c+1);
        }
        return count;
    }
    
    public static void main(String[] args){
    	CombinationSumII c = new CombinationSumII();
    	int[] a = {2};
    	c.combinationSum2(a, 1);
    }
}