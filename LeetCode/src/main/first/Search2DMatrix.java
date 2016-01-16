package first;
public class Search2DMatrix {
	public boolean searchMatrix(int[][] matrix, int v) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int m = matrix.length;
		if (m == 0) {
			return false;
		}
		int n = matrix[0].length;
		if (n == 0) {
			return false;
		}
		return binarySearch(matrix, v, 0, m * n - 1, m, n);
	}

	boolean binarySearch(int[][] matrix, int v, int start, int end, int m, int n) {
		if (start > end) {
			return false;
		}
		int p = (start + end) / 2;
		int row = p / n;
		int col = p % n;
		if (matrix[row][col] == v) {
			return true;
		} else if (matrix[row][col] > v) {
			return binarySearch(matrix, v, start, p - 1, m, n);
		} else {
			return binarySearch(matrix, v, p + 1, end, m, n);
		}
	}
}
