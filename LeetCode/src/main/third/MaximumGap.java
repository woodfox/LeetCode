package third;

/**
 * Given an unsorted array, find the maximum difference between the successive elements in its sorted form.

 Try to solve it in linear time/space.

 Return 0 if the array contains less than 2 elements.

 You may assume all elements in the array are non-negative integers and fit in the 32-bit signed integer range.
 */
public class MaximumGap {
    /**
     * Radix sort for 31 digits based on count sort (stable).
     * Or it can use bucket sort which is stable as well (use two linked list to save elements in order).
     *
     * Time: O(31*n)
     */
    public int maximumGap(int[] a) {
        int n = a.length;
        if(n<2) return 0;

        for(int i=0;i<31;i++){
            // use another array to count sort on one digit (stable sort)
            int[] b = new int[n];
            int l = 0;
            int r = n-1;
            for(int j=0;j<a.length;j++){
                int x = a[j] & (1<<i);
                if(x == 0){
                    b[l++] = a[j];
                } else {
                    b[r--] = a[j];
                }
            }

            int p = 0;
            for(int j=0;j<l;j++){
                a[p++] = b[j];
            }
            for(int j=n-1;j>r;j--){
                a[p++] = b[j];
            }
        }

        int diff = 0;
        for(int i=0;i<a.length-1;i++){
            diff = Math.max(diff, a[i+1]-a[i]);
        }
        return diff;
    }

    /**
     * Find the max and min numbers first in array, and use bucket sort to find maximum range.
     * Set bucket length = (max-min)/n+1,  and bucket number is n.
     * The max difference would be between different buckets (if max diff is in same bucket, there would be no empty bucket,
     * which means the total number of records is more than n!),  so we only need to store max/min within the bucket.
     *
     * Time: O(n)
     * Space: O(n) at most
     */
    public int maximumGap_enhancedCountSort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }

        // Handle exceptions when max == min!!
        if(max == min) {
            return 0;
        }

        // Initialize buckets
        int length = (max-min)/n+1;
        int[] minBucket = new int[n];
        int[] maxBucket = new int[n];
        for(int i=0;i<n;i++) {
            minBucket[i] = -1;
            maxBucket[i] = -1;
        }

        for(int num : nums) {
            int pos = (num - min)/length;
            if(minBucket[pos] < 0) {
                minBucket[pos] = num;
                maxBucket[pos] = num;
            } else {
                minBucket[pos] = Math.min(minBucket[pos], num);
                maxBucket[pos] = Math.max(maxBucket[pos], num);
            }
        }

        int diff = 0;
        int prev = -1;
        for(int i=0;i<n;i++){
            if(maxBucket[i] < 0){
                // No elements in this bucket
                continue;
            }

            if(prev >= 0) {
                diff = Math.max(diff, minBucket[i]-prev);
            }
            prev = maxBucket[i];
        }
        return diff;
    }

    /**
     * Find the max and min numbers first in array, and use count sort to find maximum range.
     * It throws Memory Limt Exceed if space is not limited!!
     *
     * Time: O(n)
     * Space: O(k)   k = max -min
     */
    public int maximumGap_countSort(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int num: nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }

        int size = max-min+1;
        int[] bucket = new int[size];
        for(int i=0;i<size;i++){
            bucket[i] = -1;
        }

        for(int num : nums) {
            int pos = num - min;
            bucket[pos] = num;
        }

        int diff = 0;
        int prev = -1;
        for(int num: bucket) {
            if(num < 0) {
                continue;
            }

            if(prev >= 0) {
                diff = Math.max(diff, num - prev);
            }
            prev = num;
        }
        return diff;
    }
}
