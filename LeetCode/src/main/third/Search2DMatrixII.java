package third;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

 Integers in each row are sorted in ascending from left to right.
 Integers in each column are sorted in ascending from top to bottom.
 For example,

 Consider the following matrix:

 [
 [1,   4,  7, 11, 15],
 [2,   5,  8, 12, 19],
 [3,   6,  9, 16, 22],
 [10, 13, 14, 17, 24],
 [18, 21, 23, 26, 30]
 ]
 Given target = 5, return true.

 Given target = 20, return false.
 */
public class Search2DMatrixII {
    /**
     * Step down or left from top-right corner.
     *
     * Time: O(row+col)
     */
    public boolean searchMatrix(int[][] matrix, int t) {
        int m = matrix.length;
        int n = matrix[0].length;

        int row = 0;
        int col = n-1;
        while(row <= m-1 && col >= 0) {
            if(matrix[row][col] == t) {
                return true;
            } else if(matrix[row][col] < t) {
                row++;
            } else {
                col--;
            }
        }

        return false;
    }

    /**
     * Binary search in matrix.
     *
     * Time: f(n) = 3f(n/4) + c => o(nlog4(3)) according to Master theorem
     */
    public boolean searchMatrix_slow(int[][] matrix, int t) {
        int m = matrix.length;
        if(m == 0 || matrix[0].length == 0){
            return false;
        }
        int n = matrix[0].length;
        return search(matrix, 0, 0, m-1, n-1, t);
    }

    private boolean search(int[][] matrix, int startX, int startY, int endX, int endY, int t) {
        if(startX > endX || startY > endY) {
            return false;
        } else if(startX == endX && startY == endY) {
            return matrix[startX][startY] == t;
        } else {
            int midX = (startX + endX)/2;
            int midY = (startY + endY)/2;
            if(matrix[midX][midY] == t) {
                return true;
            } else if(matrix[midX][midY] > t) {
                // Search the top and left part
                return search(matrix, startX, startY, midX-1, endY, t)
                        || search(matrix, midX, startY, endX, midY-1, t);
            } else {
                // Search the right and bottom part
                return search(matrix, startX, midY+1, endX, endY, t)
                        || search(matrix, midX+1, startY, endX, midY, t);
            }
        }
    }
}
