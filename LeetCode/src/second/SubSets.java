package second;

import java.util.ArrayList;
import java.util.Arrays;

public class SubSets {
    public ArrayList<ArrayList<Integer>> subsets(int[] s) {
        ArrayList<ArrayList<Integer>> r = new ArrayList<ArrayList<Integer>>();
        int n = s.length;
        if(n == 0){
            return r;
        }
        
        ArrayList<Integer> sub = new ArrayList<Integer>();
        Arrays.sort(s);
        for(int i=0;i<=n;i++){
            backtrack(s, 0, i, sub, r);
        }
        return r;
    }
    
    void backtrack(int[] s, int p, int k, ArrayList<Integer> sub, ArrayList<ArrayList<Integer>> r){
        if(sub.size() >= k){
            r.add(new ArrayList<Integer>(sub));
        }else{
            for(int i=p;i<s.length;i++){
                sub.add(s[i]);
                backtrack(s, i+1, k, sub, r);
                sub.remove(sub.size()-1);
            }
        }
    }
}
