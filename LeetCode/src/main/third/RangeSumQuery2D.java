package third;

public class RangeSumQuery2D {
    /**
     * Cache sum result for each row in 2d matrix.
     *
     * Cach Time: O(m*n)
     * Query Time: O(x), x is number of rows in query
     */
    private int[][] sum;

    public RangeSumQuery2D(int[][] a) {
        int m = a.length;
        if(m == 0) return;

        int n = a[0].length;
        sum = new int[m][n+1];
        for(int i=0;i<m;i++){
            for(int j=1;j<=n;j++){
                sum[i][j] = sum[i][j-1] + a[i][j-1];
            }
        }
    }

    public int sumRegion(int x1, int y1, int x2, int y2) {
        int r = 0;
        for(int i=x1;i<=x2;i++){
            r += sum[i][y2+1] - sum[i][y1];
        }
        return r;
    }

    class RangeSumQuery2D_smartCache {
        /**
         * Cache sum result for each range based on (0,0) in 2d matrix.
         *
         * Cache Time: O(m*n)
         * Query Time: O(1)
         */
        private int[][] sum;

        public RangeSumQuery2D_smartCache(int[][] a) {
            int m = a.length;
            if(m == 0) return;

            int n = a[0].length;
            sum = new int[m][n];
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    if(i == 0 && j==0) {
                        sum[i][j] = a[i][j];
                    } else if(i == 0) {
                        sum[i][j] = sum[i][j - 1] + a[i][j];
                    } else if(j==0) {
                        sum[i][j] = sum[i-1][j] + a[i][j];
                    } else {
                        sum[i][j] = sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1] + a[i][j];
                    }
                }
            }
        }

        public int sumRegion(int x1, int y1, int x2, int y2) {
            if(x1 == 0 && y1==0) {
                return sum[x2][y2];
            } else if(x1 == 0) {
                return sum[x2][y2] - sum[x2][y1-1];
            } else if(y1 == 0) {
                return sum[x2][y2] - sum[x1-1][y2];
            } else {
                return sum[x2][y2] - sum[x2][y1-1] - sum[x1-1][y2] + sum[x1-1][y1-1];
            }

        }
    }
}
