package second;

import java.util.HashMap;

public class TwoSum {
    public int[] twoSum(int[] a, int t) {
        int[] r = {-1, -1};
        int n = a.length;
        if(n > 1){
            HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
            for(int i=0;i<n;i++){
                if(map.get(t-a[i]) != null){
                    r[0] = map.get(t-a[i]) + 1;
                    r[1] = i+1;
                    return r;
                }else{
                    map.put(a[i], i);
                }
            }
        }
        return r;
    }
}
