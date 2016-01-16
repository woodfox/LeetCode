package third;

public class MinimumPathsSum {
    public int minPathSum(int[][] a) {
        int m = a.length;
        int n = a[0].length;
        int[][] matrix = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0&&j==0){
                    matrix[i][j] = a[i][j];
                }else{
                    matrix[i][j] = Integer.MAX_VALUE;
                    if(i > 0) matrix[i][j] = matrix[i-1][j] + a[i][j];
                    if(j > 0) matrix[i][j] = Math.min(matrix[i][j], matrix[i][j-1] + a[i][j]);
                }
            }
        }

        return matrix[m-1][n-1];
    }
}
