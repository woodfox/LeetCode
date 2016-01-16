package first;
public class SetZero {
	public void setZeroes(int[][] matrix) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int m = matrix.length;
		if (m == 0) {
			return;
		}
		int n = matrix[0].length;
		if (n == 0) {
			return;
		}

		for (int i = 0; i < m; i++) {
			boolean flag = false;
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == 0) {
					flag = true;
					break;
				}
			}

			if (flag) {
				for (int j = 0; j < n; j++) {
					if (matrix[i][j] != 0) {
						matrix[i][j] = -1;
					}
				}
			}
		}

		for (int j = 0; j < n; j++) {
			boolean flag = false;
			for (int i = 0; i < m; i++) {
				if (matrix[i][j] == 0) {
					flag = true;
					break;
				}
			}
			if (flag) {
				for (int i = 0; i < m; i++) {
					if (matrix[i][j] != 0) {
						matrix[i][j] = -1;
					}
				}
			}
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == -1) {
					matrix[i][j] = 0;
				}
			}
		}
	}

	public void setZeroesWithExtraSpace(int[][] matrix) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int m = matrix.length;
		if (m == 0) {
			return;
		}
		int n = matrix[0].length;
		if (n == 0) {
			return;
		}

		int[] rows = new int[m];
		int[] cols = new int[n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == 0) {
					rows[i] = 1;
					cols[j] = 1;
				}
			}
		}

		for (int i = 0; i < m; i++) {
			if (rows[i] == 1) {
				for (int j = 0; j < n; j++) {
					matrix[i][j] = 0;
				}
			}
		}

		for (int j = 0; j < n; j++) {
			if (cols[j] == 1) {
				for (int i = 0; i < m; i++) {
					matrix[i][j] = 0;
				}
			}
		}
	}
}
