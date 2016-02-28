package third;

/**
 * There are a row of n houses, each house can be painted with one of the k colors. The cost of painting each house with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color.

 The cost of painting each house with a certain color is represented by a n x k cost matrix. For example, costs[0][0] is the cost of painting house 0 with color 0; costs[1][2] is the cost of painting house 1 with color 2, and so on... Find the minimum cost to paint all houses.

 Note
 All costs are positive integers.

 Follow up: Could you solve it in O(nk) runtime?
 */
public class PaintHouseII {
    /**
     * To acheive time O(nk), we need to save two minimal index for previous row;
     * then for current row, just need to use min1/min2 if they are not same column.
     */
    int minCost(int[][] a) {
        int m = a.length;
        if(m == 0) return 0;
        int n = a[0].length;
        int[][] dp = new int[m][n];
        int min1= - 1;
        int min2 = -1;
        for(int i=0;i<m;i++){
            int min3 = -1;
            int min4 = -1;
            for(int j=0;j<n;j++){
                if(min1 == -1) {
                    dp[i][j] = a[i][j];
                } else {
                    if(j != min1) {
                        dp[i][j] = dp[i-1][min1] + a[i][j];
                    } else {
                        dp[i][j] = dp[i-1][min2] + a[i][j];
                    }
                }

                if(min3 == -1 || dp[i][j] < dp[i][min3]) {
                    min4 = min3;
                    min3 = j;
                } else if(min4 == -1 || dp[i][j] < dp[i][min4]){
                    min4 = j;
                }
            }

            min1 = min3;
            min2 = min4;
        }

        int cost = Integer.MAX_VALUE;
        for(int j=0;j<n;j++){
            cost = Math.min(cost, dp[m-1][j]);
        }

        return cost;
    }
}
