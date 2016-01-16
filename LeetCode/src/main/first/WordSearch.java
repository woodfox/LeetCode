package first;

public class WordSearch {
	public boolean exist(char[][] board, String s) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (s.length() == 0) {
			return true;
		}

		int n = board.length;
		if (n == 0) {
			return false;
		}
		int m = board[0].length;
		if (m == 0) {
			return false;
		}

		char c = s.charAt(0);
		boolean[][] used = new boolean[n][m]; 
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (board[i][j] == c) {
					used[i][j] = true;
					if (walk(board, s, i, j, 1, used)) {
						return true;
					}
					used[i][j] = false;
				}
			}
		}
		return false;
	}

	boolean walk(char[][] board, String s, int i, int j, int k, boolean[][] used) {
		if (k == s.length()) {
			return true;
		}
		char c = s.charAt(k);
		if (i > 0 && used[i - 1][j] == false && board[i - 1][j] == c) {
			used[i-1][j] = true;
			if (walk(board, s, i - 1, j, k + 1, used)) {
				return true;
			}
			used[i-1][j] = false;
		}
		if (i < board.length - 1 && used[i + 1][j] == false
				&& board[i + 1][j] == c) {
			used[i+1][j] = true;
			if (walk(board, s, i + 1, j, k + 1, used)) {
				return true;
			}
			used[i+1][j] = false;
		}
		if (j > 0 && used[i][j - 1] == false && board[i][j - 1] == c) {
			used[i][j-1] = true;
			if (walk(board, s, i, j - 1, k + 1, used)) {
				return true;
			}
			used[i][j-1] = false;
		}
		if (j < board[0].length - 1 && used[i][j + 1] == false
				&& board[i][j + 1] == c) {
			used[i][j+1] = true;
			if (walk(board, s, i, j + 1, k + 1, used)) {
				return true;
			}
			used[i][j+1] = false;
		}

		return false;
	}
	
	// Use DFS to search words in board. Time complexity is O(n^4)
	// This will throw Time Limited Exceeded error for large data set.
	public boolean existDfs(char[][] board, String s) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (s.length() == 0) {
			return true;
		}

		int n = board.length;
		if (n == 0) {
			return false;
		}
		int m = board[0].length;
		if (m == 0) {
			return false;
		}

		char c = s.charAt(0);
		Node[][] g = buildGraph(board);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (board[i][j] == c) {
					g[i][j].visited = true;
					if (dfs(g, s, i, j, 1)) {
						return true;
					}
					g[i][j].visited = false;
				}
			}
		}
		return false;
	}

	Node[][] buildGraph(char[][] board) {
		int n = board.length;
		int m = board[0].length;
		Node[][] g = new Node[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				g[i][j] = new Node(board[i][j]);
			}
		}
		return g;
	}

	boolean dfs(Node[][] g, String s, int i, int j, int k) {
		if (k == s.length()) {
			return true;
		}
		char c = s.charAt(k);
		if (i > 0 && g[i - 1][j].visited == false && g[i - 1][j].val == c) {
			g[i-1][j].visited = true;
			if (dfs(g, s, i - 1, j, k + 1)) {
				return true;
			}
			g[i-1][j].visited = false;
		}
		if (i < g.length - 1 && g[i + 1][j].visited == false
				&& g[i + 1][j].val == c) {
			g[i+1][j].visited = true;
			if (dfs(g, s, i + 1, j, k + 1)) {
				return true;
			}
			g[i+1][j].visited = false;
		}
		if (j > 0 && g[i][j - 1].visited == false && g[i][j - 1].val == c) {
			g[i][j-1].visited = true;
			if (dfs(g, s, i, j - 1, k + 1)) {
				return true;
			}
			g[i][j-1].visited = false;
		}
		if (j < g[0].length - 1 && g[i][j + 1].visited == false
				&& g[i][j + 1].val == c) {
			g[i][j+1].visited = true;
			if (dfs(g, s, i, j + 1, k + 1)) {
				return true;
			}
			g[i][j+1].visited = false;
		}

		return false;
	}

	class Node {
		char val;
		boolean visited = false;

		public Node(char c) {
			val = c;
		}
	}
}
