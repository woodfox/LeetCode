package first;
import java.util.ArrayList;
import java.util.Arrays;

public class Subsets {
	public ArrayList<ArrayList<Integer>> subsets(int[] s) {
		// Start typing your Java solution below
		// DO NOT write main() function
		Arrays.sort(s);
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i <= s.length; i++) {
			ArrayList<Integer> sub = new ArrayList<Integer>();
			backtrack(result, sub, s, -1, 0, i);
		}
		return result;
	}

	void backtrack(ArrayList<ArrayList<Integer>> result,
			ArrayList<Integer> sub, int[] s, int prev, int k, int n) {
		if (k == n) {
			ArrayList<Integer> dup = new ArrayList<Integer>(sub);
			result.add(dup);
		} else {
			for (int j = prev + 1; j < s.length; j++) {
				sub.add(s[j]);
				backtrack(result, sub, s, j, k + 1, n);
				sub.remove(sub.size() - 1);
			}
		}
	}
}
