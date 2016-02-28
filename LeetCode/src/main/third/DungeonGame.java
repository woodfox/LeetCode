package third;

/**
 * The demons had captured the princess (P) and imprisoned her in the bottom-right corner of a dungeon. The dungeon consists of M x N rooms laid out in a 2D grid. Our valiant knight (K) was initially positioned in the top-left room and must fight his way through the dungeon to rescue the princess.

 The knight has an initial health point represented by a positive integer. If at any point his health point drops to 0 or below, he dies immediately.

 Some of the rooms are guarded by demons, so the knight loses health (negative integers) upon entering these rooms; other rooms are either empty (0's) or contain magic orbs that increase the knight's health (positive integers).

 In order to reach the princess as quickly as possible, the knight decides to move only rightward or downward in each step.


 Write a function to determine the knight's minimum initial health so that he is able to rescue the princess.

 For example, given the dungeon below, the initial health of the knight must be at least 7 if he follows the optimal path RIGHT-> RIGHT -> DOWN -> DOWN.

 -2 (K) 	-3	    3
 -5	        -10	    1
 10	        30	    -5 (P)

 Notes:

 The knight's health has no upper bound.
 Any room can contain threats or power-ups, even the first room the knight enters and the bottom-right room where the princess is imprisoned.
 */
public class DungeonGame {
    /**
     * // Minimum health before entering a room
     * dp(i, j) = | 1(if a[i][j]>=0) or 1-a[i][j]    if i==m-1, j==n-1
     *            | max(1, dp(i,j+1)-a[i][j]         if i == m-1
     *            | max(1, dp(i+1,j)-a[i][j]         if j == n-1
     *            | min(max(1, dp(i+1,j)-a[i][j]), max(1, dp(i,j+1)-a[i][j])  if i<m-1,j<n-1
     *
     * Be careful:
     * 1. Starts from end point!!
     */
    public int calculateMinimumHP(int[][] a) {
        int m = a.length;
        if(m == 0) {
            return -1;
        }
        int n = a[0].length;

        int[][] dp = new int[m][n];
        for(int i=m-1;i>=0;i--) {
            for(int j=n-1;j>=0;j--){
                if(i==m-1 && j==n-1) {
                    if(a[i][j] >= 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = 1 - a[i][j];
                    }
                } else if(i==m-1) {
                    dp[i][j] = Math.max(1, dp[i][j+1] - a[i][j]);
                } else if(j == n-1) {
                    dp[i][j] = Math.max(1, dp[i + 1][j] - a[i][j]);
                }else {
                    int down = Math.max(1, dp[i+1][j] - a[i][j]);
                    int right = Math.max(1, dp[i][j+1] - a[i][j]);

                    // Choose path with minimum required health point
                    dp[i][j] = Math.min(down, right);
                }
            }
        }

        return dp[0][0];
    }
}
