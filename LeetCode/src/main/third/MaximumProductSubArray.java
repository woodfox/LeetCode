package third;

public class MaximumProductSubArray {
    /**
     * Max product of sub array ending at position i:
     *
     * f(i) = | a[i]    if i = 0
     *        | max(f[i-1]*a[i], a[i])     if a[i] >= 0
     *        | max(g[i-1]*a[i], a[i])     if a[i] < 0
     *
     * Min Product of sub array ending at position i:
     * gf(i) = | a[i]    if i = 0
     *         | min(g[i-1]*a[i], a[i])     if a[i] >= 0
     *         | min(f[i-1]*a[i], a[i])     if a[i] < 0
     *
     * Time: O(n)
     *
     * Be careful:
     * 1. Need to check every maxProduct[i], not only maxProduct[n-1]!!
     * 2. maxProduct may be negative, while minProduct may be positive
     */
    public int maxProduct(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }

        int max = Integer.MIN_VALUE;
        int n = nums.length;
        int[] maxProduct = new int[n];
        int[] minProduct = new int[n];

        for(int i=0;i<n;i++){
            if(i == 0) {
                maxProduct[0] = nums[0];
                minProduct[0] = nums[0];
            } else if(nums[i] >= 0) {
                maxProduct[i] = Math.max(maxProduct[i-1]*nums[i], nums[i]);
                minProduct[i] = Math.min(minProduct[i-1]*nums[i], nums[i]);
            } else {
                maxProduct[i] = Math.max(minProduct[i-1]*nums[i], nums[i]);
                minProduct[i] = Math.min(maxProduct[i-1]*nums[i], nums[i]);
            }

            max = Math.max(max, maxProduct[i]);
        }

        return max;
    }
}
