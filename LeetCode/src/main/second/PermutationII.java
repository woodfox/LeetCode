package second;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class PermutationII {
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] l) {
    	ArrayList<ArrayList<Integer>> r = new ArrayList<ArrayList<Integer>>();
    	int n = l.length;
    	if(n == 0){
    		return r;
    	}
        
        HashSet<Integer> set = new HashSet<Integer>();
        for(int x : l){
            set.add(x);
        }
        ArrayList<Integer> list = new ArrayList<Integer>(set);
        HashMap<Integer, Integer> map = count(l);
        ArrayList<Integer> sub = new ArrayList<Integer>();
        backtrack(list, map, sub, r, n);
        return r;
    }
    
    void backtrack(ArrayList<Integer> list, HashMap<Integer, Integer> map, ArrayList<Integer> sub, 
                   ArrayList<ArrayList<Integer>> r, int n){
        int k = sub.size();
        if(k >= n){
            r.add(new ArrayList<Integer>(sub));
        }else{
            for(int x : list){
                if(map.get(x) > 0){
                    map.put(x, map.get(x) -1);
                    sub.add(x);
                    backtrack(list, map, sub, r, n);
                    map.put(x, map.get(x) + 1);
                    sub.remove(sub.size()-1);
                }
            }
        }
    }
    
    HashMap<Integer, Integer> count(int[] l){
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int x : l){
            if(map.get(x) == null){
                map.put(x, 1);
            }else{
                map.put(x, map.get(x)+1);
            }
        }
        return map;
    }
}
