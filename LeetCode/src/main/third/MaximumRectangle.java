package third;

public class MaximumRectangle {
    /**
     * Calcualte the max length of row with 1 for each position, and then find the max rectangle with length*height
     * Time complexity: O(n^3)
     */
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        if(m == 0) return 0;

        int n = matrix[0].length;
        if(n==0) return 0;

        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if(matrix[i][j] == '1'){
                    if(j > 0){
                        dp[i][j] = dp[i][j-1] + 1;
                    }else{
                        dp[i][j] = 1;
                    }
                }
            }
        }

        int result = 0;
        for(int i=0;i<m;i++) {
            for (int j=0; j<n; j++) {
                int max = dp[i][j];
                for(int k=i;k>=0;k--){
                    max = Math.min(max, dp[k][j]);
                    if(max == 0) break;

                    result = Math.max(result, max*(i-k+1));
                }
            }
        }

        return result;
    }

    /**
     *    0 0 1 1 1 0 1
     *    1 0 1 1 0 1 1
     *    1 1 1 1 1 1 1
     *    0 0 0 1 1 0 1
     *    1 1 0 0 0 0 0
     *
     *
     *  Time Complexity: O(n^4)
     */
    public int maximalRectangle_slow(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][][][] rec = new int[m][n][m][n];
        int max = 0;
        for(int startX=0;startX<m;startX++){
            for(int startY=0;startY<n;startY++){

                for(int endX=startX;endX<m;endX++){
                    for(int endY=startY;endY<n;endY++){
                        if(endX == startX && endY == startY){
                            rec[startX][startY][startX][startY] = (matrix[startX][startY] - '0');
                        }else if(endX == startX){
                            if(rec[startX][startY][endX][endY-1]>0 && matrix[endX][endY] == '1'){
                                rec[startX][startY][endX][endY] = rec[startX][startY][endX][endY-1] + 1;
                            }else{
                                rec[startX][startY][endX][endY] = 0;
                            }
                        }else if(endY == startY){
                            if(rec[startX][startY][endX-1][endY]>0 && matrix[endX][endY] == '1'){
                                rec[startX][startY][endX][endY] = rec[startX][startY][endX-1][endY] + 1;
                            }else{
                                rec[startX][startY][endX][endY] = 0;
                            }
                        }else{
                            if(rec[startX][startY][endX-1][endY]>0 && rec[startX][startY][endX][endY-1]>0 && matrix[endX][endY] == '1'){
                                rec[startX][startY][endX][endY] = rec[startX][startY][endX-1][endY] + (endY-startY+1);
                            }else{
                                rec[startX][startY][endX][endY] = 0;
                            }
                        }

                        max = Math.max(max, rec[startX][startY][endX][endY]);
                    }
                }
            }
        }

        return max;
    }
}
