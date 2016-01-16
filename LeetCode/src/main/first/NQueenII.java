package first;
public class NQueenII {
	public int totalNQueens(int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (n == 1) {
			return 1;
		} else if (n < 4) {
			return 0;
		}

		int[][] free = new int[n][n];
		return count(n, 0, free);
	}

	int count(int n, int k, int[][] free) {
		if (k == n) {
			return 1;
		} else {
			int sum = 0;
			for (int i = 0; i < n; i++) {
				if (free[k][i] == 0) {
					setFree(free, k, i, 1);
					sum += count(n, k + 1, free);
					setFree(free, k, i, -1);
				}
			}
			return sum;
		}
	}

	// update free matrix to add or subtract 1
	void setFree(int[][] free, int i, int j, int flag) {
		int n = free.length;
		for (int k = 0; k < n; k++) {
			free[i][k] += flag;
			free[k][j] += flag;

			if (i + k < n && j + k < n) {
				free[i + k][j + k] += flag;
			}
			if (i - k >= 0 && j - k >= 0) {
				free[i - k][j - k] += flag;
			}
			if (i + k < n && j - k >= 0) {
				free[i + k][j - k] += flag;
			}
			if (i - k >= 0 && j + k < n) {
				free[i - k][j + k] += flag;
			}
		}
	}
}
