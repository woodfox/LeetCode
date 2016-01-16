package third;

public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];

        int count = 1;
        for(int length=0;length<=(n-1)/2;length++){
            int upRow = length;
            int downRow = n-length-1;
            int leftCol = length;
            int rightCol = n-length-1;

            if(upRow == downRow){
                matrix[upRow][leftCol] = count++;
            }else{
                for(int i=leftCol;i<rightCol;i++) matrix[upRow][i] = count++;
                for(int i=upRow;i<downRow;i++) matrix[i][rightCol] = count++;
                for(int i=rightCol;i>leftCol;i--) matrix[downRow][i] = count++;
                for(int i=downRow;i>upRow;i--) matrix[i][leftCol] = count++;
            }
        }

        return matrix;
    }
}
