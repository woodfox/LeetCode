package third;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LongestIncreasingPath {
    /**
     * DFS way to find maximum increasing path.
     * Use longest array to remember the longest length from one position.
     *
     * Time: O(m*n)
     */
    public int longestIncreasingPath(int[][] a) {
        int m = a.length;
        if(m == 0 || a[0].length == 0) return 0;
        int n = a[0].length;


        int len = 0;
        int[][] longest = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                len = Math.max(len, dfs(a, visited, longest, i, j));
            }
        }
        return len;
    }

    private int dfs(int[][] a, boolean[][] visited, int[][] longest, int i, int j) {
        if(longest[i][j] > 0) return longest[i][j];

        int m = a.length;
        int n = a[0].length;
        visited[i][j] = true;
        int len = 0;
        int[][] path = {{i+1,j}, {i-1,j}, {i,j-1}, {i,j+1}};
        for(int[] p : path) {
            int x = p[0];
            int y = p[1];
            if(x>=0 && x<m && y>=0 && y<n && !visited[x][y] && a[x][y]>a[i][j]) {
                len = Math.max(len, dfs(a, visited, longest, x, y));
            }
        }

        // Erase the path at last so that it can be accessed from another path next time!
        visited[i][j] = false;

        longest[i][j] = len+1;
        return longest[i][j];
    }

    /**
     * DP way: sort values, and starts from smallest to largest to update the length of surroundings.
     *
     * Time: O(m*n)
     */
    public int longestIncreasingPath_DP(int[][] a) {
        int m = a.length;
        if (m == 0 || a[0].length == 0) return 0;
        int n = a[0].length;


        int len = 0;
        List<int[]> l = new ArrayList();
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                l.add(new int[] {i, j, a[i][j]});
            }
        }
        Collections.sort(l, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });

        int[][] dp = new int[m][n];
        for(int[] pos : l) {
            int x = pos[0];
            int y = pos[1];
            // Initially length is at least 1
            dp[x][y] = Math.max(dp[x][y], 1);

            int[][] path = {{x+1,y},{x-1,y},{x,y-1},{x,y+1}};
            for(int[] p: path) {
                int i = p[0];
                int j = p[1];
                // Update length of surrounding areas
                if(i>=0 && i<m && j>=0 && j<n && a[i][j]>a[x][y]) {
                  dp[i][j] = Math.max(dp[i][j], dp[x][y]+1);
                }
            }

            len = Math.max(len, dp[x][y]);
        }
        return len;
    }
}
