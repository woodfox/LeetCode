package third;

/**
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

 Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
 */
public class HouseRobber {
    /**
     * Max money if robing house i:
     * local[i] = a[i] + global[i-2]  (if i-2>=0);
     *
     * max money at house i (robbing or not robbing):
     * global[i] = max(global[i-1], local[i])
     */
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 0) {
            return 0;
        }

        int[] l = new int[n+1];
        int[] g = new int[n+1];
        l[0] = 0;
        g[0] = 0;

        for(int i=1;i<=n;i++) {
            l[i] = nums[i-1];
            if(i-2 >= 0) {
                l[i] += g[i-2];
            }

            g[i] = Math.max(g[i-1], l[i]);
        }

        return g[n];
    }
}
