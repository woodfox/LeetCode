package first;
public class MinPathII {
	public int uniquePathsWithObstacles(int[][] a) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int m = a.length;
		if (m == 0) {
			return 0;
		}
		int n = a[0].length;
		if (n == 0) {
			return 0;
		}
		int[][] f = new int[m][n];
		for (int i = m - 1; i >= 0; i--) {
			for (int j = n - 1; j >= 0; j--) {
				if (a[i][j] == 1) {
					f[i][j] = 0;
				} else if (i == m - 1 && j == n - 1) {
					f[i][j] = 1;
				} else if (i == m - 1) {
					f[i][j] = f[i][j + 1];
				} else if (j == n - 1) {
					f[i][j] = f[i + 1][j];
				} else {
					f[i][j] = f[i + 1][j] + f[i][j + 1];
				}
			}
		}
		return f[0][0];
	}
}
