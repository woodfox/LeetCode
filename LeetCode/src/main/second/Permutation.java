package second;

import java.util.ArrayList;

public class Permutation {
	   public ArrayList<ArrayList<Integer>> permute(int[] l) {
	        ArrayList<ArrayList<Integer>> r = new ArrayList<ArrayList<Integer>>();
	        int n = l.length;
	        if(n == 0){
	            return r;
	        }
	        boolean[] a = new boolean[n];
	        ArrayList<Integer> sub = new ArrayList<Integer>();
	        backtrack(0, a, l, sub, r);
	        return r;
	    }
	    
	    void backtrack(int k, boolean[] a, int[] l, ArrayList<Integer> sub, ArrayList<ArrayList<Integer>> r){
	        if(k >= a.length){
	            r.add(new ArrayList<Integer>(sub));
	        }else{
	            for(int i=0;i<a.length;i++){
	                if(!a[i]){
	                    a[i] = true;
	                    sub.add(l[i]);
	                    backtrack(k+1, a, l, sub, r);
	                    a[i] = false;
	                    sub.remove(sub.size()-1);
	                }
	            }
	        }
	    }
}
