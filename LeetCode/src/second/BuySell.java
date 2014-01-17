package second;

public class BuySell {
	public int maxProfit(int[] a) {
		if (a == null || a.length <= 1) {
			return 0;
		}

		int n = a.length;
		int[] dp = new int[n];
		dp[0] = a[0];
		int max = 0;
		for (int i = 1; i < n; i++) {
			dp[i] = Math.min(dp[i - 1], a[i - 1]);
			max = Math.max(max, a[i] - dp[i]);
		}
		return max;
	}
}
