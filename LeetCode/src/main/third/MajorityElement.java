package third;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

 You may assume that the array is non-empty and the majority element always exist in the array.
 */
public class MajorityElement {
    /**
     * majority voting algorithm.
     *
     * Time: O(n),  Space: O(1)
     */
    public int majorityElement(int[] nums) {
        int result = 0;
        int count = 0;
        for(int i=0;i<nums.length;i++) {
            if(count == 0) {
                result = nums[i];
                count++;
            } else if(nums[i] == result) {
                count++;
            } else {
                count--;
            }
        }

        return result;
    }


    /**
     * Use set to count elements.
     *
     * Time: O(n),  Space: O(n)
     */
    public int majorityElement_space(int[] nums) {
        if(nums == null || nums.length == 0) {
            return -1;
        }

        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int num : nums) {
            Integer count = map.get(num);
            if(count == null) {
                count = 0;
            }
            count++;
            map.put(num, count);

            if(count > n/2){
                return num;
            }
        }
        return -1;
    }
}
