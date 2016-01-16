package third;

import java.util.*;

public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> sub = new ArrayList<Integer>();
        backtrace(candidates, 0, 0, target, sub, result);

        Set<List<Integer>> set = new HashSet<List<Integer>>();
        set.addAll(result);
        List<List<Integer>> uniqueResult = new ArrayList<List<Integer>>();
        uniqueResult.addAll(set);
        return uniqueResult;
    }

    private void backtrace(int[] candidates, int pos, int sum, int target, List<Integer> sub, List<List<Integer>> result) {
        if(pos >= candidates.length) return;

        for(int i=pos;i<candidates.length;i++){
            if(sum + candidates[i] == target){
                List<Integer> list = new ArrayList<Integer>();
                list.addAll(sub);
                list.add(candidates[i]);
                result.add(list);
            }else if(sum + candidates[i] < target){
                sub.add(candidates[i]);
                backtrace(candidates, i+1, sum+candidates[i], target, sub, result);
                sub.remove(sub.size()-1);
            }
        }
    }
}
