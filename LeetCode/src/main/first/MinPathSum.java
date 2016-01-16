package first;
public class MinPathSum {
	public int minPathSum(int[][] grid) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int m = grid.length;
		if (m == 0) {
			return 0;
		}
		int n = grid[0].length;
		if (n == 0) {
			return 0;
		}

		int[][] f = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (i == 0 && j == 0) {
					f[i][j] = grid[i][j];
				} else {
					int left = Integer.MAX_VALUE;
					int up = Integer.MAX_VALUE;
					if (i > 0) {
						up = f[i - 1][j];
					}
					if (j > 0) {
						left = f[i][j - 1];
					}
					f[i][j] = Math.min(left, up) + grid[i][j];
				}
			}
		}
		return f[m - 1][n - 1];
	}
	
	public static void main(String[] args){
		MinPathSum m = new MinPathSum();
		int[][] grid = {{1,2},{1,1}};
		System.out.println("Expected 3, Actual:" + m.minPathSum(grid));
	}
}
