package other;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an integer matrix, find a submatrix where the sum of numbers is zero.
 * Your code should return the coordinate of the left-up and right-down number.
 */
public class SubMatrixSum {
    /**
     * For fixed left and right column, calculate row sum, and use Map to check if there are sub array
     * in row sum that total sum is 0 (which is sum of sub matrix)
     *
     * Time: O(n^3)
     *
     * Be careful:
     *   1. Init rowSum for every left!
     */
    public int[][] submatrixSum(int[][] a) {
        int m = a.length;
        if (m == 0 || a[0].length == 0) return null;
        int n = a[0].length;

        for(int left=0;left<n;left++){
            int[] rowSum = new int[m];
            for(int right=left;right<n;right++){
                for(int i=0;i<m;i++) rowSum[i] += a[i][right];

                int sum = 0;
                Map<Integer, Integer> map = new HashMap();
                for(int i=0;i<m;i++){
                    sum += rowSum[i];
                    if(sum==0) {
                        return new int[][] { {0,left}, {i,right}};
                    } else if(map.containsKey(sum)) {
                        // Last position + 1 is the starting of sub array
                        int top = map.get(sum)+1;
                        return new int[][] { {top, left}, {i, right}};
                    }

                    // Save sum and row position i
                    map.put(sum, i);
                }
            }
        }

        return null;
    }

    // Time: O(n^4)
    public int[][] submatrixSum_slow(int[][] a) {
        int m = a.length;
        if(m==0 || a[0].length ==0) return null;
        int n = a[0].length;

        int[][] sum = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                for(int x=i;x<m;x++){
                    for(int y=j;y<n;y++){
                        if(x==i && y==j) {
                            sum[x][y] = a[x][y];
                        } else if(x==i){
                            sum[x][y] = sum[x][y-1] + a[x][y];
                        } else if(y==j){
                            sum[x][y] = sum[x-1][y] + a[x][y];
                        } else {
                            sum[x][y] = sum[x-1][y] + sum[x][y-1] + a[x][y] - sum[x-1][y-1];
                        }

                        if(sum[x][y] == 0) {
                            return new int[][] {{i,j}, {x,y}};
                        }
                    }
                }
            }
        }

        return null;
    }
}
