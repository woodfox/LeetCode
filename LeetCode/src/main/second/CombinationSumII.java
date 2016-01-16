package second;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class CombinationSumII {
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] a, int t) {
        ArrayList<ArrayList<Integer>> r = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> sub = new ArrayList<Integer>();
        
        ArrayList<Integer> list = removeDuplicate(a);
        HashMap<Integer, Integer> map = count(a);
        Collections.sort(list);
        
        backtrack(0, 0, list, t, map, sub, r);
        return r;
    }
    
    void backtrack(int k, int sum, ArrayList<Integer> l, int t, HashMap<Integer, Integer> map,
            ArrayList<Integer> sub, ArrayList<ArrayList<Integer>> r){
        if(sum > t){
            return;
        }else if(sum == t){
            r.add(new ArrayList<Integer>(sub));
        }else{
            for(int i=k;i<l.size();i++){
                int x = l.get(i);
                if(map.get(x) > 0){
                    map.put(x, map.get(x)-1);
                    sub.add(x);
                    backtrack(i, sum+x, l, t, map, sub, r);
                    map.put(x, map.get(x) + 1);
                    sub.remove(sub.size() - 1);
                }
            }
        }
    }
    
    
    ArrayList<Integer> removeDuplicate(int[] a){
        HashSet<Integer> set = new HashSet<Integer>();
        for(int x : a){
            set.add(x);
        }
        ArrayList<Integer> list = new ArrayList<Integer>(set);
        return list;
    }
    
    HashMap<Integer, Integer> count(int[] a){
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int x : a){
            if(map.get(x) == null){
                map.put(x, 1);
            }else{
                map.put(x, map.get(x)+1);
            }
        }
        return map;
    }
}
