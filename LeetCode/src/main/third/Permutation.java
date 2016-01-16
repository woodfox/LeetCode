package third;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Permutation {
    public List<List<Integer>> permute(int[] num) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> sub = new ArrayList<Integer>();
        Map<Integer, Integer> map = getCountMap(num);

        backtrack(map, num.length, sub, result);

        return result;
    }

    private void backtrack(Map<Integer, Integer> map, int n, List<Integer> sub, List<List<Integer>> result) {
        if(sub.size() == n){
            List<Integer> dup = new ArrayList<Integer>(sub);
            result.add(dup);
        }else{
            for(int a : map.keySet()){
                int count = map.get(a);
                if(count > 0) {
                    sub.add(a);
                    map.put(a, count-1);
                    backtrack(map, n, sub, result);
                    sub.remove(sub.size() - 1);
                    map.put(a, count);
                }
            }
        }
    }

    private Map<Integer, Integer> getCountMap(int[] num) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int a : num) {
            if(map.containsKey(a)){
                map.put(a, map.get(a) + 1);
            }else{
                map.put(a, 1);
            }
        }
        return map;
    }
}
