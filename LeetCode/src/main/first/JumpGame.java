package first;
public class JumpGame {
	public boolean canJump(int[] a) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int n = a.length;
		if (n == 0) {
			return false;
		}
		boolean[] f = new boolean[n];
		f[0] = true;
		for (int i = 1; i < n; i++) {
			for (int j = i - 1; j >= 0; j--) {
				if (f[j] && a[j] >= i - j) {
					f[i] = true;
					break;
				}
			}
		}
		return f[n - 1];
	}
}
