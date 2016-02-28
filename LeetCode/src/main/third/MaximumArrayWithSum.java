package third;

import java.util.HashMap;
import java.util.Map;

public class MaximumArrayWithSum {
    public int maxSubArrayLen(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        Map<Integer, Integer> map = new HashMap();
        // Have to set sum 0 with index -1.
        // So when it found sum == t at position i, the length will be i+1
        map.put(0, -1);

        int sum = 0;
        int len = 0;
        for(int i=0;i<nums.length;i++) {
            sum += nums[i];

            // If found index that [0,index] + k = [0, i], then update the result
            if(map.containsKey(sum-k)) {
                int index = map.get(sum-k);
                len = Math.max(len, i-index);
            }

            // Put the previous sum of range [0, i] into map
            if(!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }

        return len;
    }
    /**
     * Slow way to calculate max sub array with sum as k.
     *
     * Time: O(n^2)
     */
    public int maxSubArrayLen_slow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;

        int n = nums.length;
        int len = 0;
        for(int i=0;i<n;i++){
            int sum = 0;
            for(int j=i;j<n;j++) {
                sum += nums[j];
                if(sum == k) {
                    len = Math.max(len, j-i+1);
                }
            }
        }

        return len;
    }
}
