package third;

/**
 * Given an unsorted array of integers, find the length of longest increasing subsequence.

 For example,
 Given [10, 9, 2, 5, 3, 7, 101, 18],
 The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. Note that there may be more than one LIS combination, it is only necessary for you to return the length.

 Your algorithm should run in O(n2) complexity.

 Follow up: Could you improve it to O(n log n) time complexity?
 */
public class LongestIncreasingSeq {
    /**
     * Accumulate max increasing sub array.
     * If a[i] is smaller than some elements in increasing sequence, replace it
     * with first larger or equal element in seq;
     * If it's larger than last element in seq, increase the length;
     *
     *
     * Time: O(nlgn)
     *
     * Be careful:
     *   1. Should not reset the length when inserting a number in the middle of sequence.
     */
    public int lengthOfLIS(int[] a) {
        int n = a.length;
        if (n == 0) return 0;
        int[] seq = new int[n];
        seq[0] = a[0];
        int length = 1;

        for(int i=1;i<n;i++) {
            if(a[i] <= seq[0]) {
                seq[0] = a[i];
            } else if(a[i] > seq[length-1]) {
                seq[length++] = a[i];
            } else {
                int j = findFirstLarge(seq, 0, length-1, a[i]);
                seq[j] = a[i];
            }
        }
        return length;
    }

    /**
     * Find the first larger or equal positions for new increasing sub array.
     */
    private int findFirstLarge(int[] seq, int l, int r, int p) {
        while(l+1 < r) {
            int m = (l+r)/2;
            if(seq[m] >= p) {
                r = m-1;
            } else {
                l = m;
            }
        }
        return l+1;
    }

    /**
     * f(i) = max (f(j) + 1), j<i && f(i) > f(j)
     *
     * Time: O(n^2)
     */
    public int lengthOfLIS_slow(int[] a) {
        int n = a.length;
        if(n == 0) return 0;
        int[] dp = new int[n];
        dp[0] = 1;
        int max = 1;
        for(int i=1;i<n;i++){
            dp[i] = 1;
            for(int j=i-1;j>=0;j--){
                if(a[i] > a[j]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }

            max = Math.max(max, dp[i]);
        }

        return max;
    }
}
