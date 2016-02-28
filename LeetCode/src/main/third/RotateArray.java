package third;

/**
 * Rotate an array of n elements to the right by k steps.

 For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].

 Note:
 Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
 */
public class RotateArray {
    public void rotate(int[] nums, int k) {
        rotateBySwap(nums, k);
    }

    /**
     * Move the whole string from left to right
     *
     * Time: O(nk)
     */
    public int[] rotateByMove(int[] nums, int k) {
        int n = nums.length;
        k = k%n;
        if(k == 0) {
            return nums;
        }

       for(int i=0;i<k;i++) {
           int pos = n-k+i;
           int tmp = nums[pos];
           for(int j=pos-1;j>=i;j--){
               nums[j+1] = nums[j];
           }
           nums[i] = tmp;
       }

        return nums;
    }

    /**
     * Swap twice
     * Time: O()
     */
    public int[] rotateBySwap(int[] nums, int k) {
        int n = nums.length;
        k = k%n;
        if(k == 0) {
            return nums;
        }

        swap(nums, 0, n-1);
        swap(nums, 0, k-1);
        swap(nums, k, n-1);
        return nums;
    }

    private void swap(int[] nums, int start, int end) {
        while(start < end) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;

            start++;
            end--;
        }
    }
}
