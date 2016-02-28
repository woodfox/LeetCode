package third;

public class MinimumInRotatedArray {
    /**
     * Method2:  Find rotation point i, and return min (a[i], a[0])
     *
     * Time: O(lgn)
     */
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0) {
            return -1;
        }
        int n = nums.length;

        int start = 0;
        int end = n-1;
        while(nums[start] > nums[end]) {
            int m = (start+end)/2;
            if(nums[m] > nums[end]) {
                start = m + 1;
            } else {
                end = m;
            }
        }
        return nums[start];
    }

    /**
     * for a[start, end], m = (start + end)/2
     * if a[m] < a[start], continue on a[start, m]
     * if a[m] > a[start] & a[end] > a[start],  continue on left a[start, m]
     * else,  continue on right a[m, end].
     *
     * Time: O(lgn)
     */
    public int findMin1(int[] nums) {
        if(nums == null || nums.length == 0) {
            return -1;
        }
        int n = nums.length;

        return binarySearch(nums, 0, n-1);
    }

    int binarySearch(int[] nums, int start, int end) {
        if(start == end) {
            // One element left
            return nums[start];
        } else if(start == end -1) {
            // Two elements
            return Math.min(nums[start], nums[end]);
        } else {
            // m will not be start or end when there are more than two elements
            // So it will reduce the search length every time.
            int m =  (start+end)/2;
            if(nums[m] < nums[start] || nums[end] > nums[start]) {
                return binarySearch(nums, start, m);
            } else {
                return binarySearch(nums, m, end);
            }
        }
    }
}
