package second;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class SubSetII {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        HashSet<Integer> set = new HashSet<Integer>();
        for(int x:num){
            set.add(x);
        }
        
        ArrayList<Integer> l = new ArrayList<Integer>(set);
        Collections.sort(l);
        HashMap<Integer, Integer> map = count(num);
        
        ArrayList<ArrayList<Integer>> r = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> sub = new ArrayList<Integer>();
        for(int i=0;i<=num.length;i++){
            backtrack(l, 0, i, sub, r, map);
        }
        return r;
    }
    void backtrack(ArrayList<Integer> l, int p, int k, ArrayList<Integer> sub, 
                   ArrayList<ArrayList<Integer>> r, HashMap<Integer, Integer> map){
        if(sub.size() == k){
            r.add(new ArrayList<Integer>(sub));
        }else{
            for(int i=p;i<l.size();i++){
                int x = l.get(i);
                if(map.get(x) > 0){
                    sub.add(x);
                    map.put(x, map.get(x)-1);
                    backtrack(l, i, k, sub, r, map);
                    sub.remove(sub.size()-1);
                    map.put(x, map.get(x) + 1);
                }
            }
        }
    }
    
    HashMap<Integer, Integer> count(int[] a){
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int x:a){
            if(map.get(x) == null){
                map.put(x, 1);
            }else{
                map.put(x, map.get(x)+1);
            }
        }
        return map;
    }
}
