package third;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number on it represented by array nums. You are asked to burst all the balloons. If the you burst balloon i you will get nums[left] * nums[i] * nums[right] coins. Here left and right are adjacent indices of i. After the burst, the left and right then becomes adjacent.

 Find the maximum coins you can collect by bursting the balloons wisely.

 Note:
 (1) You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can not burst them.
 (2) 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100

 Example:

 Given [3, 1, 5, 8]

 Return 167

 nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
 coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
 */
public class BurstBallons {
    /**
     * dp[i,j] is the max coins when bursting booms between i and j(exclusive)
     * For dp[i,j], try to find position m as last ballon that has max coins.
     *
     * dp[i,j] = max(dp[i,j], nums[i]*nums[k]*nums[j] + dp[i,k] + dp[k,j],    i<k<<j
     * (j-i>=2)
     *
     * Reference: https://leetcode.com/discuss/72216/share-some-analysis-and-explanations
     *
     * Time: O(n^3)
     */
    public int maxCoins(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;

        int[] a = new int[n+2];
        a[0] = 1;
        a[n+1] = 1;
        for(int i=0;i<n;i++){
            a[i+1] = nums[i];
        }

        int[][] dp = new int[n+2][n+2];
        for(int k=2;k<=n+1;k++){
            for(int i=0;i+k<=n+1;i++){
                int j = i+k;
                for(int m=i+1;m<j;m++){
                    dp[i][j] = Math.max(dp[i][j], a[i]*a[m]*a[j] + dp[i][m] + dp[m][j]);
                }
            }
        }
        return dp[0][n+1];
    }

    // Use memo to cache the result of max coins between (i,j) exclusive.
    public int maxCoins_cache(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;

        int[] a = new int[n+2];
        a[0] = 1;
        a[n+1] = 1;
        for(int i=0;i<n;i++){
            a[i+1] = nums[i];
        }

        int[][] memo = new int[n+2][n+2];
        return burst(memo, a, 0, n+1);
    }

    private int burst(int[][] memo, int[] a, int l, int r) {
        if(memo[l][r] > 0) return memo[l][r];
        else if(r-l<2) return 0; // At least three elements

        for(int i=l+1;i<r;i++){
            memo[l][r] = Math.max(memo[l][r], a[l]*a[r]*a[i] + burst(memo, a, l, i) + burst(memo, a, i, r));
        }
        return memo[l][r];
    }

    /**
     * Brute force to try all possible combinations and get max coins.
     * Limit Time Exceeded!
     */
    private int max = 0;
    public int maxCoins_slow(int[] nums) {
        int n = nums.length;
        if(n==0) return 0;

        max = 0;
        List<Integer> l = new ArrayList();
        for(int x: nums) l.add(x);
        backtrack(l, 0);

        return max;
    }

    private void backtrack(List<Integer> l, int sum) {
        if(l.isEmpty()) {
            max = Math.max(max, sum);
        } else {
            for(int i=0;i<l.size();i++){
                int left = 1;
                if(i>0) left = l.get(i-1);
                int right = 1;
                if(i<l.size()-1) right = l.get(i+1);

                int x = l.remove(i);
                backtrack(l, sum+x*left*right);
                l.add(i, x);
            }
        }
    }
}
