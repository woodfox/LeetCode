package first;
public class MaximumSubarray {
	public int maxSubArray(int[] a) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int n = a.length;
		if (n == 0) {
			return 0;
		}

		int[] f = new int[n];
		f[0] = a[0];
		int max = a[0];
		for (int i = 1; i < n; i++) {
			f[i] = Math.max(0, f[i - 1]) + a[i];
			if (max < f[i]) {
				max = f[i];
			}
		}
		return max;
	}
}
