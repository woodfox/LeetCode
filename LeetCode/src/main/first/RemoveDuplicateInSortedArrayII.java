package first;
public class RemoveDuplicateInSortedArrayII {
	public int removeDuplicates(int[] a) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int n = a.length;
		if (n == 0) {
			return 0;
		}

		int prev = 0;
		int count = 0;
		for (int i = 1; i < n; i++) {
			if (a[i] == a[prev]) {
				count++;
				if (count >= 2) {
					a[i] = Integer.MIN_VALUE;
				}
			} else {
				count = 0;
				prev = i;
			}
		}

		int i = 1;
		int j = 1;
		while (i < n && j < n) {
			while (i < n && a[i] != Integer.MIN_VALUE) {
				i++;
			}
			if (j < i) {
				j = i + 1;
			}
			while (j < n && a[j] == Integer.MIN_VALUE) {
				j++;
			}
			if (j < n) {
				a[i] = a[j];
				a[j] = Integer.MIN_VALUE;
				i++;
				j++;
			}
		}

		return i;
	}
}
