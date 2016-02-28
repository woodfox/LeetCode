package third;

/**
 * There are a row of n houses, each house can be painted with one of the three colors: red, blue or green. The cost of painting each house with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color.

 The cost of painting each house with a certain color is represented by a n x 3 cost matrix. For example, costs[0][0] is the cost of painting house 0 with color red; costs[1][2] is the cost of painting house 1 with color green, and so on... Find the minimum cost to paint all houses.
 */
public class PaintHouses {
    /**
     * DP way with time: O(6n)
     */
    public int minCost(int[][] a) {
        int m = a.length;
        if(m == 0) return 0;
        int n = a[0].length;
        int[][] dp = new int[m][n];
        int cost = Integer.MAX_VALUE;

        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(i==0){
                    dp[i][j] = a[i][j];
                } else {
                    dp[i][j] = Integer.MAX_VALUE;
                    for(int k=0;k<n;k++){
                        if(k == j) continue;
                        dp[i][j] = Math.min(dp[i][j], dp[i-1][k]+a[i][j]);
                    }
                }
            }
        }

        for(int j=0;j<n;j++){
            cost = Math.min(cost, dp[m-1][j]);
        }

        return cost;
    }

    /**
     * Enhanced with O(1) space
     */
    public int minCost_enhanced(int[][] a) {
        int m = a.length;
        if (m == 0) return 0;
        int n = 3;
        int[] dp = new int[n];
        for(int i=0;i<n;i++) {
            dp[i] = a[0][i];
        }

        for(int i=1;i<m;i++){
            int x = Math.min(dp[1],dp[2]) + a[i][0];
            int y = Math.min(dp[0],dp[2]) + a[i][1];
            int z = Math.min(dp[0],dp[1]) + a[i][2];

            dp[0] = x;
            dp[1] = y;
            dp[2] = z;
        }

        return Math.min(dp[0], Math.min(dp[1], dp[2]));
    }
}
