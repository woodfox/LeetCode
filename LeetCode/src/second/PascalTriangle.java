package second;

import java.util.ArrayList;

public class PascalTriangle {
	public ArrayList<ArrayList<Integer>> generate(int n) {
		ArrayList<ArrayList<Integer>> r = new ArrayList<ArrayList<Integer>>();
		if (n == 0) {
			return r;
		}

		for (int i = 0; i < n; i++) {
			r.add(new ArrayList<Integer>());
		}

		r.get(0).add(1);
		for (int i = 1; i < n; i++) {
			r.get(i).add(1);
			for (int j = 1; j < i; j++) {
				r.get(i).add(r.get(i - 1).get(j - 1) + r.get(i - 1).get(j));
			}
			r.get(i).add(1);
		}
		return r;
	}

}
