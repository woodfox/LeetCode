package third;

/**
 * Given an array of n positive integers and a positive integer s, find the minimal length of a subarray of which the sum ≥ s. If there isn't one, return 0 instead.

 For example, given the array [2,3,1,2,4,3] and s = 7,
 the subarray [4,3] has the minimal length under the problem constraint.
 */
public class MinSizeSubArraySum {
    /**
     * Simpler logic with only one loop:
     *   Find the left and right to satisfy sum[right]-sum[left]>=t, then move left or right accordingly
     *
     * Time: O(n)
     */
    public int minimumSize(int[] a, int t) {
        int n = a.length;
        if (n == 0) return -1;
        int[] sum = new int[n + 1];
        sum[0] = 0;
        for (int i = 0; i < n; i++) sum[i + 1] = sum[i] + a[i];

        int l = 0;
        int r = 1;
        int len = Integer.MAX_VALUE;
        while (r <= n) {
            if(sum[r]-sum[l]>=t){
                len = Math.min(len, r-l);
            }

            if(sum[r]-sum[l]>=t){
                l++;
            }else{
                r++;
            }
        }
        if(len == Integer.MAX_VALUE) return -1;
        else return len;
    }

    public int minSubArrayLen_complex(int s, int[] a) {
        if(a.length <= 0 || s == 0) {
            return 0;
        }

        int start = 0;
        int end = 0;
        int n = a.length;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        // Q: 0 <= sum < s,  start <= end
        while(end < n) {
            // Invariant: sum(start, end) >=s OR end >= n
            while(end < n && sum < s) {
                sum += a[end];
                end++;
            }
            // Invariant: sum(start, end) >= s && (end-start) is minimal length
            while(sum - a[start] >= s) {
                sum -= a[start];
                start++;
            }

            if(sum >= s) {
                min = Math.min(min, end-start);
            }

            // At last, need to make sure sum < s
            sum -= a[start];
            start++;
        }

        if(min == Integer.MAX_VALUE) {
            return 0;
        } else {
            return min;
        }
    }
}
