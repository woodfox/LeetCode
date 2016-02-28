package third;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a sorted integer array where the range of elements are [0, 99] inclusive, return its missing ranges. For example, given [0, 1, 3, 50, 75], return [“2”, “4->49”, “51->74”, “76->99”]

 Example Questions Candidate Might Ask:

 Q: What if the given array is empty?
 A: Then you should return [“0->99”] as those ranges are missing.
 Q: What if the given array contains all elements from the ranges?
 A: Return an empty list, which means no range is missing.
 */
public class MissingRange {
    public List<String> findMissingRanges(int[] nums, int start, int end) {
        List<String> result = new ArrayList<String>();
        if(nums == null || nums.length == 0) {
            result.add(start + "->" + end);
            return result;
        }

        int from = -1;
        int to = -1;
        for(int i=0;i<nums.length;i++) {
            if(i > 0 && nums[i] == nums[i-1]) {
                // Exclude duplicated elements
                continue;
            }

            if(from == -1) {
                from = nums[i];
                to = nums[i];

                // At first needs to add missing range
                if(nums[i] > start) {
                    result.add(start + "->" + (nums[i]-1));
                }
            } else if(nums[i] == to+1) {
                // continue the previous range
                to = nums[i];
            } else {
                // Add the missing range, and continue with a new range
                result.add(to+1 + "->" + (nums[i]-1));
                from = nums[i];
                to = nums[i];
            }
        }

        if(to < end) {
            result.add(to+1 + "->" + end);
        }
        return result;
    }
}
