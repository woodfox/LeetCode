package first;
import java.util.ArrayList;

public class Combinations {
	public ArrayList<ArrayList<Integer>> combine(int n, int k) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> list = new ArrayList<Integer>();
		backtrack(result, list, 0, 0, n, k);
		return result;
	}

	void backtrack(ArrayList<ArrayList<Integer>> result,
			ArrayList<Integer> list, int prev, int c, int n, int k) {
		if (c == k) {
			ArrayList<Integer> dup = new ArrayList<Integer>(list);
			result.add(dup);
		} else {
			for (int i = prev + 1; i <= n; i++) {
				list.add(i);
				backtrack(result, list, i, c + 1, n, k);
				list.remove(list.size() - 1);
			}
		}
	}
}
