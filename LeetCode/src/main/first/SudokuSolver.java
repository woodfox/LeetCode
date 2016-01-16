package first;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class SudokuSolver {
	//For every possible option, check directly if it's valid.
	public void solveSudoku(char[][] a) {
		// Start typing your Java solution below
		// DO NOT write main() function
		backtrack(a, 0);
	}

	boolean backtrack(char[][] a, int k) {
		int i = k/9;
		int j = k%9;
		if (k == 81) {
			return true;
		}else if(a[i][j] != '.'){
			return backtrack(a, k+1);
		} else {
			for(char x = '1';x<='9';x++){
				a[i][j] = x;
				if (isValid(a, i, j) && backtrack(a, k+1)) {
					return true;
				}
			}
			a[i][j] = '.';
		}
		return false;
	}
	
	boolean isValid(char[][] a, int i, int j){
		char c = a[i][j];
		for (int k = 0; k < 9; k++) {
			if (k!= j && a[i][k] == c) {
				return false;
			}
			if (k != i && a[k][j] == c) {
				return false;
			}
		}
		
		//Also check the belonged 3*3 grid
		int x = i/3;
		int y = j/3;
		for(int s=0;s<3;s++){
			for(int t=0;t<3;t++){
				char p = a[x*3+s][y*3+t];
				if(x*3+s != i && y*3+t != j && p == c){
					return false;
				}
			}
		}
		return true;
	}
	
	ArrayList<Character> getCandicates(char[][] a, int i, int j) {
		ArrayList<Character> r = new ArrayList<Character>();
		HashMap<Character, Integer> c = new HashMap<Character, Integer>();
		for (int k = 1; k <= 9; k++) {
			c.put((char) (k + '0'), 1);
		}
		for (int k = 0; k < 9; k++) {
			if (a[i][k] != '.') {
				c.put(a[i][k], c.get(a[i][k]) - 1);
			}
			if (a[k][j] != '.') {
				c.put(a[k][j], c.get(a[k][j]) - 1);
			}
		}

		//Also check the belonged 3*3 grid
		int x = i/3;
		int y = j/3;
		for(int s=0;s<3;s++){
			for(int t=0;t<3;t++){
				if(x*3+s == x || y*3+t == j){
					continue;
				}
				char p = a[x*3+s][y*3+t];
				if(p != '.'){
					c.put(p, c.get(p)-1);
				}
			}
		}
		
		for (char num : c.keySet()) {
			if (c.get(num) > 0) {
				r.add(num);
			}
		}
		return r;
	}

	public static void main(String[] args){
		String[] a = {"...2...63","3....54.1","..1..398.",".......9.","...538...",".3.......",".263..5..","5.37....8","47...1..."};
		char[][] board = new char[9][9];
		for(int i=0;i<9;i++){
			for(int j=0;j<9;j++){
				board[i][j] = a[i].charAt(j);
			}
		}
		
		SudokuSolver s = new SudokuSolver();
		long before = System.currentTimeMillis();
		s.solveSudoku(board);
		long after = System.currentTimeMillis();
		System.out.println(after - before);
		s.printBoard(board);
	}
	

	private void printBoard(char[][] a) {
		for(int i=0;i<9;i++){
			for(int j=0;j<9;j++){
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("---------------------------------");
	}
	
	//------------------------Another solutoin with TLE error!
	//Will throw TLE error!!
	public void solveSudokuSlow(char[][] a) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int[] rows = new int[9];
		int[] cols = new int[9];
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (a[i][j] != '.') {
					rows[i]++;
				}
				if (a[j][i] != '.') {
					cols[i]++;
				}
			}
		}
		PriorityQueue<Position> q = new PriorityQueue<Position>(81,
				new CountComparator());
		Position[][] board = new Position[9][9];
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (a[i][j] == '.') {
					board[i][j] = new Position(i, j, rows[i] + cols[j]);
					q.offer(board[i][j]);
				}
			}
		}
		backtrack2(a, q, board);
	}

	boolean backtrack2(char[][] a, PriorityQueue<Position> q, Position[][] board) {
		//printBoard(a);
		if (q.isEmpty()) {
			return true;
		} else {
			Position p = q.poll();
			ArrayList<Character> c = getCandicates2(a, p.x, p.y);
			updateCount(board, p.x, p.y, 1);
			for (char x : c) {
				a[p.x][p.y] = x;
				if (backtrack2(a, q, board)) {
					return true;
				}
			}
			a[p.x][p.y] = '.';
			updateCount(board, p.x, p.y, -1);
			q.offer(p);
		}
		return false;
	}

	void updateCount(Position[][] board, int i, int j, int num){
		for(int k=0;k<9;k++){
			if(board[i][k] != null){
				board[i][k].count += num;
			}
			if(board[k][j] != null){
				board[k][j].count += num;
			}
		}
	}
	
	ArrayList<Character> getCandicates2(char[][] a, int i, int j) {
		ArrayList<Character> r = new ArrayList<Character>();
		HashMap<Character, Integer> c = new HashMap<Character, Integer>();
		for (int k = 1; k <= 9; k++) {
			c.put((char) (k + '0'), 1);
		}
		for (int k = 0; k < 9; k++) {
			if (a[i][k] != '.') {
				c.put(a[i][k], c.get(a[i][k]) - 1);
			}
			if (a[k][j] != '.') {
				c.put(a[k][j], c.get(a[k][j]) - 1);
			}
		}

		//Also check the belonged 3*3 grid
		int x = i/3;
		int y = j/3;
		for(int s=0;s<3;s++){
			for(int t=0;t<3;t++){
				char p = a[x*3+s][y*3+t];
				if(p != '.'){
					c.put(p, c.get(p)-1);
				}
			}
		}
		
		for (char num : c.keySet()) {
			if (c.get(num) > 0) {
				r.add(num);
			}
		}
		return r;
	}

	public class Position {
		int x;
		int y;
		int count;

		public Position(int i, int j, int c) {
			x = i;
			y = j;
			count = c;
		}
	}

	public class CountComparator implements Comparator<Position> {
		public int compare(Position p1, Position p2) {
			if (p1.count >= p2.count) {
				return -1;
			} else {
				return 1;
			}
		}
	}
}