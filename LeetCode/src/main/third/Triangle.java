package third;

import java.util.List;

/**
 *            | a[i][0]              if i == 0
 *  f(i,j) =  | f(i-1, j) + a[i][j]  if j == 0
 *            | f(i-1, j-1) + a[i][j] if j == i
 *            | min(f(i-1, j-1), f(i-1, j)) + a[i][j]
 *
 *  i = row number (0..n-1), j = column number (0..i)
 */
public class Triangle {
    // Enhanced version with space O(2*n)
    public int minimumTotal(List<List<Integer>> t) {
        int n = t.size();
        if(n == 0) {
            return 0;
        }
        int[] current = new int[n];
        int[] next = new int[n];

        for(int i=0;i<n;i++) {
            List<Integer> row = t.get(i);
            for(int j=0;j<=i;j++){
                Integer value = row.get(j);
                if(i == 0) {
                    next[j] = value;
                } else if(j == 0) {
                    next[j] = current[j] + value;
                } else if(j == i) {
                    next[j] = current[j-1] + value;
                } else {
                    next[j] = Math.min(current[j-1], current[j]) + value;
                }
            }
            int[] tmp = current;
            current = next;
            next = tmp;
        }

        // Get the min sum only for last column!!
        int min = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            min = Math.min(min, current[i]);
        }

        return min;
    }

    // DP with space O(n^2)
    public int minimumTotal_dp(List<List<Integer>> t) {
        int n = t.size();
        int[][] dp = new int[n][n];

        for(int i=0;i<n;i++) {
            List<Integer> row = t.get(i);
            for(int j=0;j<=i;j++){
                Integer value = row.get(j);
                if(i == 0) {
                    dp[i][j] = value;
                } else if(j == 0) {
                    dp[i][j] = dp[i-1][j] + value;
                } else if(j == i) {
                    dp[i][j] = dp[i-1][j-1] + value;
                } else {
                    dp[i][j] = Math.min(dp[i-1][j-1], dp[i-1][j]) + value;
                }
            }
        }

        // Get the min sum only for last column!!
        int min = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            min = Math.min(min, dp[n-1][i]);
        }

        return min;
    }
}
