package third;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSetII {
    /**
     *  Back track with two options:
     *    Option1: Add current element and continue with next one (no matter equal or not)
     *    Option2: No not add current element and the following equal elements, and continue with diff-value elements.
     *
     *  Time Complexity: O(2^n)
     */
    List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> set = new ArrayList<Integer>();

        for(int i=0;i<=nums.length;i++){
            backtrack(nums, 0, i, set, result);
        }
        return result;
    }

    private  void backtrack(int[] nums, int pos, int total, List<Integer> set, List<List<Integer>> result) {
        if(set.size() >= total){
            result.add(new ArrayList<Integer>(set));
        }else if(pos < nums.length) {
            // Option1: Add current element into set (check if it's within the length!)
            set.add(nums[pos]);
            backtrack(nums, pos + 1, total, set, result);
            set.remove(set.size() - 1);

            // Option2: Do not add current element, and skip the same elements until different one
            int next = pos + 1;
            while(next < nums.length && nums[next] == nums[next-1]) {
                next++;
            }
            backtrack(nums, next, total, set, result);
        }
    }
}
