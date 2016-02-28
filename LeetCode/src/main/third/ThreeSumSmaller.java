package third;

import java.util.Arrays;

/**
 * Given an array of n integers nums and a target, find the number of index triplets i, j, k with 0 <= i < j < k < n
 that satisfy the condition nums[i] + nums[j] + nums[k] < target.

 For example, given nums = [-2, 0, 1, 3], and target = 2.

 Return 2. Because there are two triplets which sums are less than 2:

 [-2, 0, 1]
 [-2, 0, 3]

 Follow up:
 Could you solve it in O(n^2) runtime?
 */
public class ThreeSumSmaller {
    /**
     * Choose one element and check two sum smaller
     * Two sum smaller: Move pointer from start and end and count the total that sum < t
     */
    int threeSumSmaller(int[] a, int t) {
        Arrays.sort(a);
        int r = 0;
        for(int i=0;i<a.length-2;i++){
            r += twoSumSmaller(a, i+1, t-a[i]);
        }
        return r;
    }
    int twoSumSmaller(int[] a, int p, int t){
        int x = 0;
        int l = p;
        int r = a.length-1;
        while(l < r) {
            while(l < r && a[l] + a[r] >= t) {
                r--;
            }

            x += (r - l);
            l++;
        }
        return x;
    }

    /**
     * Slower version with O(n^3)
     */
    int threeSumSmaller_slow(int[] a, int t) {
        Arrays.sort(a);
        return backtrack(a, 0, 0, 0, t);
    }

    int backtrack(int[] a, int pos, int n, int r, int t){
        if(n == 3 && r < t) {
            return 1;
        } else if(r >= t) {
            return 0;
        } else{
            int total = 0;
            for(int i=pos;i<a.length;i++){
                total += backtrack(a, i+1, n+1, r+a[i], t);
            }
            return total;
        }
    }
}
