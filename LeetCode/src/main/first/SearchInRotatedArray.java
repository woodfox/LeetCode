package first;
public class SearchInRotatedArray {
	public int search(int[] a, int v) {
		// Start typing your Java solution below
		// DO NOT write main() function
		return binarySearch(a, 0, a.length - 1, v);
	}

	int binarySearch(int[] a, int start, int end, int v) {
		if (start > end) {
			return -1;
		}

		int m = (start + end) / 2;
		if (v == a[m]) {
			return m;
		} else if (v < a[m]) {
			if ((a[m] > a[start] && v >= a[start]) || a[m] < a[start]) {
				return binarySearch(a, start, m - 1, v);
			} else {
				return binarySearch(a, m + 1, end, v);
			}
		} else {
			if ((a[m] < a[end] && v <= a[end]) || a[end] < a[m]) {
				return binarySearch(a, m + 1, end, v);
			} else {
				return binarySearch(a, start, m - 1, v);
			}
		}
	}
}
