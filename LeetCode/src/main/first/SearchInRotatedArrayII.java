package first;
public class SearchInRotatedArrayII {
	public boolean search(int[] a, int v) {
		// Start typing your Java solution below
		// DO NOT write main() function
		return binarySearch(a, 0, a.length - 1, v);
	}

	boolean binarySearch(int[] a, int start, int end, int v) {
		if (start > end) {
			return false;
		}
		int m = (start + end) / 2;
		if (a[m] == v) {
			return true;
		} else if (v < a[m]) {
			if (a[m] == a[start]) {
				while (start < m && a[start] == a[m]) {
					start++;
				}
			}
			if ((a[m] > a[start] && v >= a[start]) || a[m] < a[start]) {
				return binarySearch(a, start, m - 1, v);
			} else {
				return binarySearch(a, m + 1, end, v);
			}
		} else {
			if (a[m] == a[end]) {
				while (end > m && a[end] == a[m]) {
					end--;
				}
			}
			if ((a[m] < a[end] && v <= a[end]) || a[m] > a[end]) {
				return binarySearch(a, m + 1, end, v);
			} else {
				return binarySearch(a, start, m - 1, v);
			}
		}
	}
	
	public static void main(String[] args){
		SearchInRotatedArrayII s = new SearchInRotatedArrayII();
		int[] a = {3,1,1};
		System.out.println(s.search(a, 3));
	}
}