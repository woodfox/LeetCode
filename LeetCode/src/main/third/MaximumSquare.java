package third;

/**
 * Given a 2D binary matrix filled with 0's and 1's, find the largest square containing all 1's and return its area.

 For example, given the following matrix:

 1 0 1 0 0
 1 0 1 1 1
 1 1 1 1 1
 1 0 0 1 0
 Return 4.
 */
public class MaximumSquare  {
    /**
     * Enhanced DP:
     * f(i) = min(f(i-1,j), f(i, j-1), f(i-1,j-1))
     *
     * Time: O(n^2)
     */
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        if(m == 0) return 0;
        int n = matrix[0].length;

        int[][] dp = new int[m][n];
        int max = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j] == '0'){
                    dp[i][j] = 0;
                }else if(i == 0 || j == 0) {
                    dp[i][j] = 1;
                } else {
                    // Only need to check minimal of three cells
                    dp[i][j] = dp[i-1][j-1];
                    dp[i][j] = Math.min(dp[i][j], dp[i-1][j]);
                    dp[i][j] = Math.min(dp[i][j], dp[i][j-1]);
                    dp[i][j] += 1;
                }
                max = Math.max(max, dp[i][j]);
            }
        }

        return max*max;
    }

    // Time: O(n^3)
    public int maximalSquare_slow(char[][] matrix) {
        int m = matrix.length;
        if(m == 0) return 0;
        int n = matrix[0].length;

        int[][] dp = new int[m][n];
        int max = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j] == '0'){
                    dp[i][j] = 0;
                }else if(i == 0 || j == 0) {
                    dp[i][j] = 1;
                } else {
                    int row = i-1;
                    while(row >= i-dp[i-1][j-1]) {
                        if(matrix[row][j] == '0'){
                            break;
                        }
                        row--;
                    }
                    int col = j-1;
                    while(col >= j-dp[i-1][j-1]) {
                        if(matrix[i][col] == '0') {
                            break;
                        }
                        col--;
                    }

                    dp[i][j] = Math.min(i-row, j-col);
                }
                max = Math.max(max, dp[i][j]);
            }
        }

        return max*max;
    }
}
