package first;
import java.util.ArrayList;

public class NQueen {
	public ArrayList<String[]> solveNQueens(int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<String[]> result = new ArrayList<String[]>();
		char[][] board = new char[n][n];
		int[][] free = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				free[i][j] = 0;
				board[i][j] = '.';
			}
		}
		backtrack(board, n, 0, free, result);
		return result;
	}

	void backtrack(char[][] board, int n, int k, int[][] free,
			ArrayList<String[]> result) {
		if (k == n) {
			addResult(board, result);
		} else {
			for (int i = 0; i < n; i++) {
				if (free[k][i] == 0) {
					board[k][i] = 'Q';
					setFree(free, k, i, 1);
					backtrack(board, n, k + 1, free, result);
					board[k][i] = '.';
					setFree(free, k, i, -1);
				}
			}
		}
	}

	void addResult(char[][] board, ArrayList<String[]> result) {
		int n = board.length;
		String[] r = new String[n];
		for (int i = 0; i < n; i++) {
			r[i] = new String(board[i]);
		}
		result.add(r);
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
