package third;

public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] a) {
        int m = a.length;
        int n = a[0].length;
        int[][] matrix = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(a[i][j] == 1) {
                    matrix[i][j] = 0;
                }
                else if(i==0 && j==0){
                    matrix[i][j] = 1;
                }else{
                    if(i > 0) matrix[i][j] = matrix[i-1][j];
                    if(j > 0) matrix[i][j] += matrix[i][j-1];
                }
            }
        }
        return matrix[m-1][n-1];
    }
}
