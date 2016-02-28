package third;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array
 * such that nums[i] = nums[j] and the difference between i and j is at most k.
 */
public class ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(k == 0) {
            return false;
        }

        // K increase one to mean the element count in subarray
        k++;
        Set<Integer> set = new HashSet();
        for(int i=0;i<nums.length;i++) {
            if(set.size() >= k) {
                set.remove(nums[i-k]);
            }

            if(set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
        }

        return false;
    }
}
