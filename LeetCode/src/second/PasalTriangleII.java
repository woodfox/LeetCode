package second;

import java.util.ArrayList;

public class PasalTriangleII {
	public ArrayList<Integer> getRow(int k) {
		ArrayList<Integer> r = new ArrayList<Integer>();

		int[] a = new int[k + 1];
		a[0] = 1;
		for (int i = 0; i <= k; i++) {
			a[i] = 1;
			for (int j = i - 1; j > 0; j--) {
				a[j] = a[j - 1] + a[j];
			}
		}
		for (int x : a) {
			r.add(x);
		}
		return r;
	}
}
