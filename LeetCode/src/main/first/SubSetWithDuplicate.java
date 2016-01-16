package first;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class SubSetWithDuplicate {
	ArrayList<ArrayList<Integer>> result;

	public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] a) {
		// Start typing your Java solution below
		// DO NOT write main() function
		result = new ArrayList<ArrayList<Integer>>();
		HashMap<Integer, Integer> countMap = new HashMap<Integer, Integer>();
		ArrayList<Integer> b = new ArrayList<Integer>();
		Arrays.sort(a);
		int prev = Integer.MIN_VALUE;
		for (int i : a) {
			if (i != prev) {
				b.add(i);
				countMap.put(i, 1);
				prev = i;
			} else {
				Integer count = countMap.get(i);
				if(count == null){
					count = 0;
				}
				countMap.put(i, count + 1);
			}
		}
		result.add(new ArrayList<Integer>());
		for (int i = 1; i <= a.length; i++) {
			ArrayList<Integer> sub = new ArrayList<Integer>();
			backtrack(b, countMap, sub, i);
		}
		return result;
	}

	void backtrack(ArrayList<Integer> b, HashMap<Integer, Integer> map,
			ArrayList<Integer> sub, int length) {
		if (sub.size() == length) {
			ArrayList<Integer> r = new ArrayList<Integer>();
			r.addAll(sub);
			result.add(r);
		} else {
			ArrayList<Integer> c = getCandicate(b, map, sub);
			for (int j : c) {
				sub.add(j);
				map.put(j, map.get(j) - 1);
				backtrack(b, map, sub, length);
				sub.remove(sub.size() - 1);
				map.put(j, map.get(j) + 1);
			}
		}
	}

	ArrayList<Integer> getCandicate(ArrayList<Integer> b,
			HashMap<Integer, Integer> map, ArrayList<Integer> sub) {
		int prev = -1;
		if (sub.size() > 0) {
			prev = sub.get(sub.size() - 1);
		}
		ArrayList<Integer> c = new ArrayList<Integer>();
		for (int i : b) {
			if (i >= prev && map.get(i) > 0) {
				c.add(i);
			}
		}
		return c;
	}
	
	public static void main(String[] args){
		SubSetWithDuplicate s = new SubSetWithDuplicate();
		int[] a = {-1, 1, 2};
		s.subsetsWithDup(a);
	}
}
