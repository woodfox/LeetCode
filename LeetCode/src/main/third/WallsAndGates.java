package third;

import java.util.LinkedList;
import java.util.Queue;

/**
 * You are given a m x n 2D grid initialized with these three possible values.

 -1 - A wall or an obstacle.
 0 - A gate.
 INF - Infinity means an empty room. We use the value 2^31 - 1 = 2147483647 to represent INF
       as you may assume that the distance to a gate is less than 2147483647.
 Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.

 For example, given the 2D grid:

 INF  -1  0  INF
 INF INF INF  -1
 INF  -1 INF  -1
 0  -1 INF INF
 After running your function, the 2D grid should be:

 3  -1   0   1
 2   2   1  -1
 1  -1   2  -1
 0  -1   3   4
 */
public class WallsAndGates {
    /**
     * DFS to update shortest distance for every gate.
     *
     * Time: O(m*n*k), k is number of gates
     */
    public void wallsAndGates(int[][] a) {
        int m = a.length;
        if (m == 0) return;
        int n = a[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][j] == 0) {
                    dfs(a, i + 1, j, 1);
                    dfs(a, i - 1, j, 1);
                    dfs(a, i, j + 1, 1);
                    dfs(a, i, j - 1, 1);
                }
            }
        }
    }

    private void dfs(int[][] a, int row, int col, int p) {
        int m = a.length;
        int n = a[0].length;
        if(row < 0 || row >= m || col < 0 || col >= n || a[row][col] <= p) {
            return;
        }

        a[row][col] = p;
        dfs(a, row+1, col, p+1);
        dfs(a, row-1, col, p+1);
        dfs(a, row, col+1, p+1);
        dfs(a, row, col-1, p+1);
    }

    /**
     * BFS to update distance with nearest nodes first.
     * It should be faster than DFS.
     *
     * O(m*n)
     */
    public void wallsAndGates_bfs(int[][] a) {
        int m = a.length;
        if (m == 0) return;
        int n = a[0].length;
        Queue<int[]> q = new LinkedList<int[]>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(a[i][j] == 0) {
                    q.add(new int[] { i+1, j, 1});
                    q.add(new int[] { i-1, j, 1});
                    q.add(new int[] { i, j+1, 1});
                    q.add(new int[] { i, j-1, 1});
                }
            }
        }

        while(!q.isEmpty()) {
            int[] pos = q.poll();
            int i = pos[0];
            int j = pos[1];
            int dist = pos[2];
            if(i < 0 || i >= m || j < 0 || j >= n || a[i][j] <= dist) continue;

            a[i][j] = dist;
            q.add(new int[] { i+1, j, dist+1});
            q.add(new int[] { i-1, j, dist+1});
            q.add(new int[] { i, j+1, dist+1});
            q.add(new int[] { i, j-1, dist+1});
        }
    }
}

