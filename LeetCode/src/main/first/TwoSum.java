package first;
import java.util.HashMap;

public class TwoSum {
	public int[] twoSum(int[] a, int t) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int[] r = new int[2];
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < a.length; i++) {
			if (map.get(a[i]) != null) {
				r[0] = map.get(a[i]) + 1;
				r[1] = i + 1;
				return r;
			} else {
				map.put(t - a[i], i);
			}
		}
		return r;
	}
}
