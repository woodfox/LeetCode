package first;
import java.util.ArrayList;

public class PermutationSequence {
	int[] count = new int[10];

	public String getPermutation(int n, int k) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<Integer> l = new ArrayList<Integer>();
		for (int i = 1; i <= n; i++) {
			l.add(i);
		}
		calculatePermutateCount(n);
		StringBuffer sb = new StringBuffer();
		getKthElement(l, k, sb);
		return sb.toString();
	}

	void getKthElement(ArrayList<Integer> l, int k, StringBuffer sb) {
		int n = l.size();
		if (k == 0) {
			for (int i = n - 1; i >= 0; i--) {
				sb.append("" + l.get(i));
			}
		} else if (k == 1) {
			for (int x : l) {
				sb.append("" + x);
			}
		} else {
			int i = k / count[n - 1];
			int j = k % count[n - 1];
			if (j > 0) {
				i++;
			}
			int x = l.remove(i - 1);
			sb.append("" + x);
			getKthElement(l, j, sb);
		}
	}

	void calculatePermutateCount(int n) {
		count[1] = 1;
		for (int i = 2; i <= n; i++) {
			count[i] = i * count[i - 1];
		}
	}
}
