package first;
public class FindMissingPositive {
	public int firstMissingPositive(int[] a) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int n = a.length;
		for (int i = 0; i < a.length; i++) {
			if (a[i] <= 0) {
				a[i] = n + 2;
			}
		}
		for (int i = 0; i < a.length; i++) {
			int x = Math.abs(a[i]);
			if (x <= n) {
				a[x - 1] = -1 * Math.abs(a[x - 1]);
			}
		}
		for (int i = 0; i < a.length; i++) {
			if (a[i] > 0) {
				return i + 1;
			}
		}
		return a.length + 1;
	}
}
