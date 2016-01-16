package first;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PermutationII {
	public ArrayList<ArrayList<Integer>> permuteUnique(int[] a) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int n = a.length;
		ArrayList<Integer> sub = new ArrayList<Integer>();
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (n == 0) {
			return result;
		}

		HashMap<Integer, Integer> count = calcCount(a);
		backtrack(count, n, 0, sub, result);
		return result;
	}

	void backtrack(HashMap<Integer, Integer> count, int n, int k,
			ArrayList<Integer> sub, ArrayList<ArrayList<Integer>> result) {
		if (k == n) {
			addResult(sub, result);
		} else {
			ArrayList<Integer> c = getCandidates(count);
			for (int x : c) {
				count.put(x, count.get(x) - 1);
				sub.add(x);
				backtrack(count, n, k + 1, sub, result);
				count.put(x, count.get(x) + 1);
				sub.remove(sub.size() - 1);
			}
		}
	}

	HashMap<Integer, Integer> calcCount(int[] a) {
		HashMap<Integer, Integer> count = new HashMap<Integer, Integer>();
		for (int x : a) {
			Integer y = count.get(x);
			if (y == null) {
				y = 0;
			}
			count.put(x, y + 1);
		}
		return count;
	}

	ArrayList<Integer> getCandidates(HashMap<Integer, Integer> count) {
		ArrayList<Integer> c = new ArrayList<Integer>();
		for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
			if (entry.getValue() > 0) {
				c.add(entry.getKey());
			}
		}
		return c;
	}

	void addResult(ArrayList<Integer> sub, ArrayList<ArrayList<Integer>> result) {
		ArrayList<Integer> dup = new ArrayList<Integer>(sub);
		result.add(dup);
	}

}
