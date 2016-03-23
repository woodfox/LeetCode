package other;

import java.util.ArrayList;

/**
 * Given an array of integers, find two non-overlapping subarrays which have the largest sum.
 The number in each subarray should be contiguous.
 Return the largest sum.
 */
public class MaxSubArrayII {
    /**
     * Find the max sum of left and right for position i, and get maximum result.
     *
     * Time: O(n)
     */
    public int maxTwoSubArrays(ArrayList<Integer> nums) {
        int n = nums.size();
        if(n<=1) return 0;

        int[] left = new int[n];
        int[] leftMax = new int[n];
        left[0] = nums.get(0);
        leftMax[0] = left[0];
        for(int i=1;i<n;i++){
            left[i] = Math.max(0, left[i-1]) + nums.get(i);
            leftMax[i] = Math.max(leftMax[i-1], left[i]);
        }

        int[] right = new int[n];
        int[] rightMax = new int[n];
        right[n-1] = nums.get(n-1);
        rightMax[n-1] = right[n-1];
        for(int i=n-2;i>=0;i--){
            right[i] = Math.max(0, right[i+1]) + nums.get(i);
            rightMax[i] = Math.max(rightMax[i+1], right[i]);
        }

        int result = Integer.MIN_VALUE;
        for(int i=0;i<n-1;i++){
            result = Math.max(result, leftMax[i] + rightMax[i+1]);
        }
        return result;
    }
}
