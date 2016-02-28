package third;

import java.util.Arrays;

/**
 * Given an unsorted array nums, reorder it in-place such that nums[0] <= nums[1] >= nums[2] <= nums[3]....

 For example, given nums = [3, 5, 2, 1, 6, 4], one possible answer is [1, 6, 2, 5, 3, 4].

 The answer is not unique!!!
 */
public class WiggleSort {
    /**
     * Sort and swap the 3th with 2th, 5th with 4th, etc
     *
     * Time: O(nlgn)
     */
    void wiggleSort(int[] a) {
        Arrays.sort(a);
        for(int i=2;i<a.length;i+=2){
            int tmp = a[i];
            a[i] = a[i-1];
            a[i-1] = tmp;
        }
    }

    /**
     * Swap i and i-1 if
     *   1. i is odd and a[i] < a[i-1]
     *   2. i is even and a[i] > a[i-1]
     *
     *   Time: O(n)
     */
    void wiggleSort_fast(int[] a) {
        for(int i=1;i<a.length;i++){
            if((i%2==0 && a[i]>a[i-1]) || (i%2==1 && a[i]<a[i-1])) {
                int tmp = a[i];
                a[i] = a[i-1];
                a[i-1] = tmp;
            }
        }
    }
}
