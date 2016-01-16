package third;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {
    /**
     * Time Complexity: O(2^n)
     */
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        for(int i=0;i<=nums.length;i++){
            backtrace(nums, 0, list, result, i);
        }

        return result;
    }

    private void backtrace(int[] nums, int pos, List<Integer> list, List<List<Integer>> result, int total) {
        if(list.size() >= total){
            result.add(new ArrayList<Integer>(list));
        }else if(pos < nums.length){
            list.add(nums[pos]);
            backtrace(nums, pos+1, list, result, total);
            list.remove(list.size()-1);

            backtrace(nums, pos+1, list, result, total);
        }
    }
}
