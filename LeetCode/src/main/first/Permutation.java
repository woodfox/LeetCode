package first;

import java.util.ArrayList;

public class Permutation {
    public ArrayList<ArrayList<Integer>> permute(int[] a) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> result =
            new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> sub = new ArrayList<Integer>();
        backtrack(a, 0, sub, result);
        return result;
    }
    
    void backtrack(int[] a, int k, ArrayList<Integer> sub,
        ArrayList<ArrayList<Integer>> result) {
        if (k == a.length) {
            ArrayList<Integer> dup = new ArrayList<Integer>(sub);
            result.add(dup);
        }
        else {
            ArrayList<Integer> c = getCandicates(a, sub);
            for (int x : c) {
                sub.add(x);
                backtrack(a, k + 1, sub, result);
                sub.remove(sub.size() - 1);
            }
        }
    }
    
    
    
    ArrayList<Integer> getCandicates(int[] a, ArrayList<Integer> sub) {
        ArrayList<Integer> c = new ArrayList<Integer>();
        for (int x : a) {
            if (!sub.contains(x)) {
                c.add(x);
            }
        }
        return c;
    }
    
    public ArrayList<ArrayList<Integer>> permute2(int[] a) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> result =
            new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> sub = new ArrayList<Integer>();
        boolean[] s = new boolean[a.length];
        backtrack(a, 0, s, sub, result);
        return result;
    }
    
    
    void backtrack(int[] a, int k, boolean[] s, ArrayList<Integer> sub,
        ArrayList<ArrayList<Integer>> result) {
        if (k == a.length) {
            ArrayList<Integer> dup = new ArrayList<Integer>(sub);
            result.add(dup);
        }
        else {
            for(int i=0;i<s.length;i++){
                if(!s[i]){
                    s[i] = true;
                    sub.add(a[i]);
                    backtrack(a, k + 1, s, sub, result);
                    s[i] = false;
                    sub.remove(sub.size() - 1);
                }
            }
        }
    }  
}
