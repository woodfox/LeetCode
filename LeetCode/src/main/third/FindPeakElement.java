package third;

/**
 * A peak element is an element that is greater than its neighbors.

 Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.

 The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

 You may imagine that num[-1] = num[n] = -∞.

 For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.

 click to show spoilers.

 Note:
 Your solution should be in logarithmic complexity.
 */
public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        if(nums == null || nums.length == 0) {
            return -1;
        }

        int n = nums.length;
        return binarySearch(nums, 0, n-1);
    }

    private int binarySearch(int[] nums, int start, int end) {
        if(start <= end) {
            int m = (start+end)/2;

            if(m > start && nums[m] < nums[m-1]) {
                // Larger elements on left
                return binarySearch(nums, start, m-1);
            } else if(m < end && nums[m] < nums[m+1]) {
                // Larger elements on right
                return binarySearch(nums, m+1, end);
            } else {
                return m;
            }
        } else {
            return -1;
        }
    }
}
