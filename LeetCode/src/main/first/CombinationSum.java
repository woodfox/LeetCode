package first;
import java.util.ArrayList;
import java.util.Arrays;

public class CombinationSum {
	public ArrayList<ArrayList<Integer>> combinationSum(int[] a, int t) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		Arrays.sort(a);
		ArrayList<Integer> sub = new ArrayList<Integer>();
		backtrack(a, 0, 0, t, result, sub);
		return result;
	}

	void backtrack(int[] a, int sum, int pre, int t,
			ArrayList<ArrayList<Integer>> result, ArrayList<Integer> sub) {
		if (sum == t) {
			addResult(sub, result);
		} else if (sum > t) {
			return;
		} else {
			ArrayList<Integer> c = getCandicates(a, pre, sum, t);
			for (int x : c) {
				sub.add(a[x]);
				backtrack(a, sum + a[x], x, t, result, sub);
				sub.remove(sub.size() - 1);
			}
		}
	}

	ArrayList<Integer> getCandicates(int[] a, int pre, int sum, int t) {
		ArrayList<Integer> c = new ArrayList<Integer>();
		for (int i = pre; i < a.length; i++) {
			if (sum + a[i] > t) {
				break;
			}
			c.add(i);
		}
		return c;
	}

	void addResult(ArrayList<Integer> sub, ArrayList<ArrayList<Integer>> result) {
		ArrayList<Integer> dup = new ArrayList<Integer>(sub);
		result.add(dup);
	}
}
