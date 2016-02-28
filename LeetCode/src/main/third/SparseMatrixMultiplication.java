package third;

/**
 * Given two sparse matrices A andB, return the result of AB.

 You may assume that A's column number is equal to B's row number.

 Example:

 A = [
 [ 1, 0, 0],
 [-1, 0, 3]
 ]

 B = [
 [ 7, 0, 0 ],
 [ 0, 0, 0 ],
 [ 0, 0, 1 ]
 ]


 |  1 0 0 |   | 7 0 0 |   |  7 0 0 |
 AB = | -1 0 3 | x | 0 0 0 | = | -7 0 3 |
 | 0 0 1 |
 */
public class SparseMatrixMultiplication {
    /**
     * Do not need to multiple if a[i][k] is 0 or a[k][j] is 0
     */
    public int[][] multiply(int[][] a, int[][] b) {
        int m = a.length;
        int n = b.length;
        int l = b[0].length;
        int[][] r = new int[m][l];

        for(int i=0;i<m;i++){
            for(int k=0;k<n;k++){
                if(a[i][k] != 0) {
                    for(int j=0;j<l;j++){
                        if(b[k][j]!=0) r[i][j] += a[i][k]*b[k][j];
                    }
                }
            }
        }
        return r;
    }
}
