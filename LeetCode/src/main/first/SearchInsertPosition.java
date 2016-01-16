package first;
public class SearchInsertPosition {
	public int searchInsert(int[] a, int p) {
		// Start typing your Java solution below
		// DO NOT write main() function
		return binarySearch(a, p, 0, a.length - 1);
	}

	int binarySearch(int[] a, int p, int start, int end) {
		if (start > end) {
			return start;
		}
		int m = (start + end) / 2;
		if (a[m] == p) {
			return m;
		} else if (a[m] < p) {
			return binarySearch(a, p, m + 1, end);
		} else {
			return binarySearch(a, p, start, m - 1);
		}
	}
}
