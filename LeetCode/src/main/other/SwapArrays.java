package other;

public class SwapArrays {
    /**
     * Swap left (start, middle) and right (middle+1, end) of array
     */
    public int[] swap(int[] nums, int start, int middle, int end) {
        if(start >= end) {
            return nums;
        }

        int m = middle-start+1;
        int n = end-middle;
        if(m == n) {
            swapEqual(nums, start, middle+1, m);
        } else if(m < n) {
            int rightMiddle = end-m+1;
            swapEqual(nums, start, rightMiddle, m);
            return swap(nums, start, start+m-1, rightMiddle-1);
        } else {
            int leftMiddle = start+n;
            swapEqual(nums, start, middle+1, n);
            return swap(nums, leftMiddle, middle, end);
        }
        return nums;
    }

    private void swapEqual(int[] nums, int start1, int start2, int length) {
        for(int i=0;i<length;i++) {
            int tmp = nums[start1+i];
            nums[start1+i] = nums[start2+i];
            nums[start2+i] = tmp;
        }
    }
}
