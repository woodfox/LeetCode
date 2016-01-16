package third;

public class MatrixSearch {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0) return false;

        int m = matrix.length;
        int n = matrix[0].length;
        return binarySearch(matrix, 0, m*n-1, target);
    }

    boolean binarySearch(int[][] matrix, int start, int end, int t){
        int m = matrix.length;
        int n = matrix[0].length;
        while(start <= end){
            int midPos = (start + end)/2;
            int row = midPos/n;
            int col = midPos%n;
            if(matrix[row][col] == t){
                return true;
            }else if(matrix[row][col] < t){
                start = midPos + 1;
            }else{
                end = midPos - 1;
            }
        }
        return false;
    }
}
