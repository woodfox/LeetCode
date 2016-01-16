package second;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class ThreeSum {
    public ArrayList<ArrayList<Integer>> threeSum(int[] a) {
        Arrays.sort(a);
        ArrayList<ArrayList<Integer>> r = new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<a.length;i++){
            int x = a[i];
            if(i > 0 && a[i-1] == x){
                continue;
            }
            for(ArrayList<Integer> sub : twoSum(a, i+1, x*-1)){
                sub.add(0, x);
                r.add(sub);
            }
        }
        return r;
    }
    
    ArrayList<ArrayList<Integer>> twoSum(int[] a, int p, int x){
        ArrayList<ArrayList<Integer>> r = new ArrayList<ArrayList<Integer>>();
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i=p;i<a.length;i++){
            int y = a[i];
            if(set.contains(y)){
                if(a[i] == a[i-1] && r.size() > 0){
                    continue;
                }
                ArrayList<Integer> sub = new ArrayList<Integer>();
                sub.add(x-y);
                sub.add(y);
                r.add(sub);
            }else{
                set.add(x-y);
            }
        }
        return r;
    }
}
