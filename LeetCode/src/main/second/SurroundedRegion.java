package second;

import java.util.LinkedList;

/**
 * Starts from nodes in outside edges and set from 'O' to 'Z', then reset all other 'O's to 'X', while 'Z' to 'O';
 */
public class SurroundedRegion {
	public void solve(char[][] a) {
		int m = a.length;
		if (m == 0) {
			return;
		}
		int n = a[0].length;
		if (n == 0) {
			return;
		}

		for (int i = 0; i < n; i++) {
			bfs(a, 0, i);
			bfs(a, m - 1, i);
		}
		for (int i = 0; i < m; i++) {
			bfs(a, i, 0);
			bfs(a, i, n - 1);
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (a[i][j] == 'Z') {
					a[i][j] = 'O';
				} else if (a[i][j] == 'O') {
					a[i][j] = 'X';
				}
			}
		}
	}
	
	private void bfs(char[][] a, int i, int j){
		int m = a.length;
		int n = a[0].length;
		LinkedList<Integer> row = new LinkedList<Integer>();
		LinkedList<Integer> col = new LinkedList<Integer>();
		row.addLast(i);
		col.addLast(j);
		
		while(!row.isEmpty()){
			int r = row.removeFirst();
			int c = col.removeFirst();
			if(r < 0 || r >= m || c < 0 || c >= n || a[r][c] != 'O'){
				continue;
			}
			a[r][c] = 'Z';
			addQueue(row, col, r-1, c);
			addQueue(row, col, r+1, c);
			addQueue(row, col, r, c-1);
			addQueue(row, col, r, c+1);
		}
	}
	
	private void addQueue(LinkedList<Integer> row, LinkedList<Integer> col, int i, int j){
		row.add(i);
		col.add(j);
	}

	//DFS will throw Runtime Error!!
	private void dfs(char[][] a, int i, int j) {
		int m = a.length;
		int n = a[0].length;
		if (i >= m || j >= n || i < 0 || j < 0 || a[i][j] != 'O') {
			return;
		}

		a[i][j] = 'Z';
		dfs(a, i - 1, j);
		dfs(a, i + 1, j);
		dfs(a, i, j - 1);
		dfs(a, i, j + 1);
	}
	
	public static void main(String[] args) {
		char[][] a = {{'X', 'X', 'O', 'O'},
				{'O', 'O', 'X', 'X'},
				{'X', 'X', 'X', 'O'}};
		SurroundedRegion s = new SurroundedRegion();
		s.solve(a);
	}
}
