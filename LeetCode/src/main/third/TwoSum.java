package third;

import java.util.HashMap;

public class TwoSum {
    public int[] twoSum(int[] a, int t) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0; i<a.length; i++) {
            Integer pos = map.get(a[i]);
            if(pos != null) {
                return new int[] {pos+1, i+1};
            }else {
                map.put(t - a[i], i);
            }
        }

        return new int[] {-1, -1};
    }
}
