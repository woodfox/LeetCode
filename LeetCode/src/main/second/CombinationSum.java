package second;

import java.util.ArrayList;
import java.util.Arrays;

public class CombinationSum {
    public ArrayList<ArrayList<Integer>> combinationSum(int[] a, int t) {
        ArrayList<ArrayList<Integer>> r = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> sub = new ArrayList<Integer>();
        Arrays.sort(a);
        backtrack(0, 0, a, t, sub, r);
        return r;
    }
    
    void backtrack(int k, int sum, int[] a, int t, ArrayList<Integer> sub, ArrayList<ArrayList<Integer>> r){
        if(sum > t){
            return;
        }else if(sum == t){
            r.add(new ArrayList<Integer>(sub));
        }else{
            for(int i=k;i<a.length;i++){
                sub.add(a[i]);
                backtrack(i, sum+a[i], a, t, sub, r);
                sub.remove(sub.size()-1);
            }
        }
    }
}
