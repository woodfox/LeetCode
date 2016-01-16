package second;

import java.util.ArrayList;

public class Combinations {
	public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        ArrayList<ArrayList<Integer>> r = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> sub = new ArrayList<Integer>();
        backtrack(1, n, k, sub, r);
        return r;
    }
    
    void backtrack(int p, int n, int k, ArrayList<Integer> sub, ArrayList<ArrayList<Integer>> r){
        if(sub.size() >= k){
            r.add(new ArrayList<Integer>(sub));
        }else{
            for(int i=p;i<=n;i++){
                sub.add(i);
                backtrack(i+1, n, k, sub, r);
                sub.remove(sub.size()-1);
            }
        }
    }
}
