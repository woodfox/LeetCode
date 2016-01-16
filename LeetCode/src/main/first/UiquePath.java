package first;
public class UiquePath {
	public int uniquePaths(int m, int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (m == 0 || n == 0) {
			return 0;
		}
		int[][] f = new int[m][n];
		for (int i = m - 1; i >= 0; i--) {
			for (int j = n - 1; j >= 0; j--) {
				if (i == m - 1 && j == n - 1) {
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
