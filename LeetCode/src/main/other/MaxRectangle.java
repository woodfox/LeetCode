package other;

import java.util.PriorityQueue;

public class MaxRectangle {
    /**
     * Calculate the max length of every row for one column, and calculate max rectangle in these rows.
     *
     * Time: O(m*m*n)
     *
     * Be Careful:
     *   1. Can not use sliding window from top to bottom, since we don't know which way to move if value are same.
     */
    public int maximalRectangle(boolean[][] a) {
        int m  = a.length;
        if(m==0 || a[0].length == 0) return 0;
        int n = a[0].length;

        int size = 0;
        int[] dp = new int[m];
        for(int col=0;col<n;col++){
            for(int i=0;i<m;i++) {
                if(a[i][col]) {
                    dp[i] += 1;
                }
                else {
                    dp[i] = 0;
                }
            }

            // Find the max rectangle based on max length on that column
            for(int i=0;i<m;i++){
                int length = dp[i];
                for(int j=i;j<m;j++){
                    length = Math.min(length, dp[j]);
                    if(length==0) break;
                    size = Math.max(size, length*(j-i+1));
                }
            }
        }

        return size;
    }
}
