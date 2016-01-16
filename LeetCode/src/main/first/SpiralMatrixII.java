package first;
public class SpiralMatrixII {
	public int[][] generateMatrix(int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int[][] matrix = new int[n][n];
		int i = 0;
		int j = 0;
		int k = 1;
		int direction = 0;
		int count = 0;
		int length = 0;
		while (k <= n * n) {
			matrix[i][j] = k++;
			count++;
			if (count == (4 * (n - length * 2) - 4)) {
				length++;
				count = 0;
			}
			int x = getNextRow(i, direction);
			int y = getNextCol(j, direction);
			if (x < length || x >= n - length || y < length || y >= n - length) {
				direction = (direction + 1) % 4;
				i = getNextRow(i, direction);
				j = getNextCol(j, direction);
			} else {
				i = x;
				j = y;
			}
		}
		return matrix;
	}

	int getNextRow(int i, int direction) {
		if (direction == 0 || direction == 2) {
			return i;
		} else if (direction == 1) {
			return i + 1;
		} else {
			return i - 1;
		}
	}

	int getNextCol(int j, int direction) {
		if (direction == 1 || direction == 3) {
			return j;
		} else if (direction == 0) {
			return j + 1;
		} else {
			return j - 1;
		}
	}
}
