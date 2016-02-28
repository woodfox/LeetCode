package third;

/**
 * Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

 Solve it without division and in O(n).

 For example, given [1,2,3,4], return [24,12,8,6].
 */
public class ProductOfArrayExceptSelf {
    /**
     * Use output array to save left-side production, then use right to calculate right-side production.
     *
     * Time: O(n)
     * Space: O(1)
     */
    public int[] productExceptSelf(int[] a) {
        int n = a.length;
        int[] r = new int[n];
        r[0] = 1;
        for(int i=1;i<n;i++) {
            r[i] = r[i-1]*a[i-1];
        }
        int right = a[n-1];
        for(int i=n-2;i>=0;i--){
            r[i] = r[i] * right;
            right *= a[i];
        }
        return r;
    }

    public int[] productExceptSelf_moreSpace(int[] a) {
        int n = a.length;
        int[] left = new int[n];
        left[0] = 1;
        for(int i=1;i<n;i++){
            left[i] = left[i-1] * a[i-1];
        }

        int[] right = new int[n];
        right[n-1] = 1;
        for(int i=n-2;i>=0;i--){
            right[i] = right[i+1] * a[i+1];
        }

        int[] r = new int[n];
        for(int i=0;i<n;i++){
            r[i] = left[i]*right[i];
        }
        return r;
    }
}
