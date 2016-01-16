package third;

/**
 * Consistent space, with time complexity O(m*n)
 */
public class MatrixZeros {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        boolean isPrevRowZero = false;
        for(int i=0;i<m;i++){
            boolean isCurrentRowZero = false;
            for(int j=0;j<n;j++){
                if(matrix[i][j] == 0){
                    setColumn(matrix, i, j);
                    isCurrentRowZero = true;
                }else if(i > 0 && matrix[i-1][j] == 0){
                    matrix[i][j] = 0;
                }
            }

            if(isPrevRowZero){
                setRow(matrix, i-1);
            }
            isPrevRowZero = isCurrentRowZero;
        }

        // Do not forget to handle last line!!
        if(isPrevRowZero){
            setRow(matrix, m-1);
        }
    }

    private void setColumn(int[][] matrix, int row, int col){
        for(int i=0;i<row;i++){
            matrix[i][col] = 0;
        }
    }

    private void setRow(int[][] matrix, int row){
        for(int i=0;i<matrix[0].length;i++){
            matrix[row][i] = 0;
        }
    }
}
