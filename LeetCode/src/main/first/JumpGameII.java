package first;
public class JumpGameII {

	public int jump(int[] a) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int n = a.length;
		if (n <= 1) {
			return 0;
		}

		int start = 0;
		int end = 0;
		int steps = 0;
		while (start <= end) {
			steps++;
			int lastEnd = end;
			for (int i = start; i <= lastEnd; i++) {
				int p = i + a[i];
				if (p >= n - 1) {
					return steps;
				}
				if (p > end) {
					end = p;
				}
			}
			start = lastEnd + 1;
		}

		return steps;
	}

	// Time complexity: O(n^2)
	// This will throw TLE for large data set!!
	public int jumpDP(int[] a) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int n = a.length;
		if (n == 0) {
			return 0;
		}
		int[] f = new int[n];
		f[n - 1] = 0;
		for (int i = n - 2; i >= 0; i--) {
			f[i] = Integer.MAX_VALUE;
			for (int j = i + 1; j <= n - 1; j++) {
				if (a[i] < j - i) {
					break;
				}
				if (f[j] != Integer.MAX_VALUE && f[i] > f[j] + 1) {
					f[i] = f[j] + 1;
				}
			}
		}
		return f[0];
	}

	public static void main(String[] args){
		JumpGameII j = new JumpGameII();
		int[] a = {1, 2, 3};
		System.out.println(j.jump(a));
	}
}
