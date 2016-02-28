package third;

/**
 * Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).

 Range Sum Query 2D
 The above rectangle (with the red border) is defined by (row1, col1) = (2, 1) and (row2, col2) = (4, 3), which contains sum = 8.

 Example:
 Given matrix = [
 [3, 0, 1, 4, 2],
 [5, 6, 3, 2, 1],
 [1, 2, 0, 1, 5],
 [4, 1, 0, 1, 7],
 [1, 0, 3, 0, 5]
 ]

 sumRegion(2, 1, 4, 3) -> 8
 update(3, 2, 2)
 sumRegion(2, 1, 4, 3) -> 10
 Note:
 The matrix is only modifiable by the update function.
 You may assume the number of calls to update and sumRegion function is distributed evenly.
 You may assume that row1 ≤ row2 and col1 ≤ col2.
 */
public class RangeSumQuery2DMutable {
    /**
     * Keep the sum for every row. Eg, rowSum[i][j] is the sum of row[i][k], 0<=k<j
     */
    private int[][] a;
    int m;
    int n;
    private int[][] rowSum;

    // Time: O(m*n)
    public RangeSumQuery2DMutable(int[][] nums) {
        a = nums;
        m = a.length;
        if(m==0) return;
        n = a[0].length;

        rowSum = new int[m][n+1];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                rowSum[i][j+1] = rowSum[i][j] + a[i][j];
            }
        }
    }

    // Time: O(n)
    public void update(int i, int j, int val) {
        int diff = val - a[i][j];
        a[i][j] = val;
        for(int k=j;k<n;k++){
            rowSum[i][k+1] += diff;
        }
    }

    // Time: O(m)
    public int sumRange(int x1, int y1, int x2, int y2) {
        int sum = 0;
        for(int i=x1;i<=x2;i++){
            sum += rowSum[i][y2+1] - rowSum[i][y1];
        }
        return sum;
    }

    private class RangeSumQuery2DMutable_binaryIndexTree {
        /**
         * Use 2D Binary Index Tree to update and get sum of ranges.
         */
        private int[][] a;
        private int[][] tree;
        private int m;
        private int n;

        //Time: O(mn*logm*logn)
        public RangeSumQuery2DMutable_binaryIndexTree(int[][] nums) {
            a = nums;
            m = a.length;
            if(m == 0) return;
            n = a[0].length;
            if(n == 0) return;

            tree = new int[m+1][n+1];
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    updateTree(i+1, j+1, a[i][j]);
                }
            }
        }

        private void updateTree(int row, int col, int val) {
            if(m==0 || n==0) return;
            for(int i=row;i<=m;i+=(i&-i)){
                for(int j=col;j<=n;j+=(j&-j)){
                    tree[i][j] += val;
                }
            }
        }

        // Time: O(logm*logn)
        public void update(int i, int j, int val) {
            int diff = val - a[i][j];
            a[i][j] = val;
            updateTree(i+1, j+1, diff);
        }

        // Time: O(logm*logn)
        public int sumRange(int x1, int y1, int x2, int y2){
            return sum(x2+1,y2+1) - sum(x2+1,y1) - sum(x1,y2+1) + sum(x1,y1);
        }

        private int sum(int row, int col) {
            int sum = 0;
            for(int i=row;i>0;i-=(i&-i)){
                for(int j=col;j>0;j-=(j&-j)){
                    sum += tree[i][j];
                }
            }

            return sum;
        }
    }
}
