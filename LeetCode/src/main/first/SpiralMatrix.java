package first;
import java.util.ArrayList;

public class SpiralMatrix {
	public ArrayList<Integer> spiralOrder(int[][] a) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<Integer> l = new ArrayList<Integer>();
		int m = a.length;
		if (m == 0) {
			return l;
		}
		int n = a[0].length;
		if (n == 0) {
			return l;
		}
		int i = 0;
		int j = 0;
		int length = 0;
		int count = 0;
		int direction = 0;
		while (l.size() < m * n) {
			l.add(a[i][j]);
			count++;
			if (count == 2 * (m + n - 4 * length) - 4) {
				length++;
				count = 0;
			}
			int x = getNextRow(i, direction);
			int y = getNextCol(j, direction);
			if (x < length || x >= m - length || y < length || y >= n - length) {
				direction = (direction + 1) % 4;
				i = getNextRow(i, direction);
				j = getNextCol(j, direction);
			} else {
				i = x;
				j = y;
			}
		}
		return l;
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
	
	public static void main(String[] args){
		SpiralMatrix s = new SpiralMatrix();
		int[][] a = {{7}, {9}, {6}};
		System.out.println(s.spiralOrder(a));
	}
}
