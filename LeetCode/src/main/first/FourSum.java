package first;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class FourSum {
	// Complexity: O(n^3)
	public ArrayList<ArrayList<Integer>> fourSum(int[] a, int t) {
		// Start typing your Java solution below
		// DO NOT write main() function
		Arrays.sort(a);
		ArrayList<ArrayList<Integer>> r = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i <= a.length - 4; i++) {
			if (i > 0 && a[i] == a[i - 1]) {
				continue;
			}
			for (int j = i + 1; j <= a.length - 3; j++) {
				if (j > i + 1 && a[j] == a[j - 1]) {
					continue;
				}
				ArrayList<ArrayList<Integer>> l = twoSum(a, j, t - a[i] - a[j]);
				for (ArrayList<Integer> one : l) {
					ArrayList<Integer> sub = new ArrayList<Integer>();
					sub.add(a[i]);
					sub.add(a[j]);
					sub.addAll(one);
					r.add(sub);
				}
			}
		}
		return r;
	}

	ArrayList<ArrayList<Integer>> twoSum(int[] a, int p, int t) {
		ArrayList<ArrayList<Integer>> r = new ArrayList<ArrayList<Integer>>();
		int i = p + 1;
		int j = a.length - 1;
		while (i < j) {
			if (i > p + 1 && a[i] == a[i - 1]) {
				i++;
				continue;
			}
			if (j < a.length - 1 && a[j] == a[j + 1]) {
				j--;
				continue;
			}

			if (a[i] + a[j] == t) {
				ArrayList<Integer> sub = new ArrayList<Integer>();
				sub.add(a[i]);
				sub.add(a[j]);
				r.add(sub);
				i++;
				j--;
			} else if (a[i] + a[j] < t) {
				i++;
			} else {
				j--;
			}
		}
		return r;
	}

	// Will throw Time Limit Exceeded for large data set!
	public ArrayList<ArrayList<Integer>> fourSum2(int[] a, int t) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<ArrayList<Integer>> r = new ArrayList<ArrayList<Integer>>();
		HashMap<Integer, Integer> count = getCount(a);
		HashSet<Integer> set = new HashSet<Integer>();
		for (int x : a) {
			set.add(x);
		}
		ArrayList<Integer> b = new ArrayList<Integer>(set);
		Collections.sort(b);

		ArrayList<Integer> sub = new ArrayList<Integer>();
		backtrack(b, count, 0, 0, t, sub, r);
		return r;
	}

	void backtrack(ArrayList<Integer> b, HashMap<Integer, Integer> count,
			int k, int sum, int t, ArrayList<Integer> sub,
			ArrayList<ArrayList<Integer>> r) {
		if (k == 4 && sum == t) {
			addResult(sub, r);
		} else if (k < 4) {
			ArrayList<Integer> c = getCandicate(b, count, sum, t, sub);
			for (int x : c) {
				sub.add(x);
				count.put(x, count.get(x) - 1);
				backtrack(b, count, k + 1, sum + x, t, sub, r);
				sub.remove(sub.size() - 1);
				count.put(x, count.get(x) + 1);
			}
		}
	}

	ArrayList<Integer> getCandicate(ArrayList<Integer> b,
			HashMap<Integer, Integer> count, int sum, int t,
			ArrayList<Integer> sub) {
		int prev = Integer.MIN_VALUE;
		if (sub.size() > 0) {
			prev = sub.get(sub.size() - 1);
		}

		ArrayList<Integer> c = new ArrayList<Integer>();
		for (int x : b) {
			if (x < prev) {
				continue;
			}
			if (sum + x > t) {
				break;
			}
			if (count.get(x) > 0) {
				c.add(x);
			}
		}
		return c;
	}

	HashMap<Integer, Integer> getCount(int[] a) {
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

	void addResult(ArrayList<Integer> sub, ArrayList<ArrayList<Integer>> r) {
		ArrayList<Integer> dup = new ArrayList<Integer>(sub);
		r.add(dup);
	}
}
