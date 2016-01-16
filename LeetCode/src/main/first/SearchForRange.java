package first;
public class SearchForRange {
	public int[] searchRange(int[] a, int p) {
		// Start typing your Java solution below
		// DO NOT write main() function
		return binarySearch(a, p, 0, a.length - 1);
	}

	int[] binarySearch(int[] a, int p, int start, int end) {
		int[] range = new int[2];
		if (start > end) {
			range[0] = -1;
			range[1] = -1;
		} else {
			int m = (start + end) / 2;
			if (a[m] == p) {
				int left = m;
				while (left >= start + 1 && a[left - 1] == p) {
					left--;
				}
				int right = m;
				while (right <= end - 1 && a[right + 1] == p) {
					right++;
				}
				range[0] = left;
				range[1] = right;
			} else if (a[m] < p) {
				return binarySearch(a, p, m + 1, end);
			} else {
				return binarySearch(a, p, start, m - 1);
			}
		}
		return range;
	}

}
