package other;

/**
 * Write a function to find the longest increasing(increasing means one step) sequence in an integer matrix in 4 directions.

 For example:

 [
 [1, 2, 3, 4]
 [8, 7, 6, 5]
 ]
 should return:

 [1, 2, 3, 4, 5, 6, 7, 8]

 [
 [1, 2, 3, 9]
 [8, 7, 6, 5]
 ]
 should return:

 [5, 6, 7, 8]
 */
public class LongestIncreasingSeqInMatrix {
    /**
     * DFS + memorization
     *
     * Time: O(n)
     */
    public int longestSeq(int[][] a) {
        int m = a.length;
        if(m==0 || a[0].length==0) return 0;
        int n = a[0].length;

        int length = 0;
        int[][] cache = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                length = Math.max(length, dfs(a, i, j, cache));
            }
        }
        return length;
    }

    private int dfs(int[][] a, int i, int j, int[][] cache) {
        if(cache[i][j] > 0) return cache[i][j];
        int m = a.length;
        int n = a[0].length;

        cache[i][j] = 1;
        int[][] path = {{i+1,j}, {i-1,j}, {i, j-1}, {i, j+1}};
        for(int[] p : path) {
            int x = p[0];
            int y = p[1];
            if(x>=0 && x<m && y>=0 && y<n && a[x][y]>a[i][j]){
                int length = dfs(a, x, y, cache);
                cache[i][j] = Math.max(cache[i][j], length+1);
            }
        }

        return cache[i][j];
    }
}
