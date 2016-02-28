package third;

public class NumberofIslands {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        if(m == 0) {
            return 0;
        }
        int n = grid[0].length;
        if(n == 0) {
            return 0;
        }

        int total = 0;
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(grid[i][j] == '1') {
                    total++;
                    dfs(grid, i, j);
                }
            }
        }

        return total;
    }

    private void dfs(char[][] grid, int row, int col) {
        int m = grid.length;
        int n = grid[0].length;
        if(row < 0 || row >= m || col < 0 || col >= n || grid[row][col] != '1') {
            return;
        }

        grid[row][col] = '0';

        dfs(grid, row+1, col);
        dfs(grid, row-1, col);
        dfs(grid, row, col+1);
        dfs(grid, row, col-1);
    }
}
