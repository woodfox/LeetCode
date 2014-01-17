package second;

public class BuySellII {
	public int maxProfit(int[] a) {
		if (a == null || a.length <= 1) {
			return 0;
		}

		int sum = 0;
		int start = a[0];
		int end = a[0];
		for (int i = 1; i < a.length; i++) {
			if (a[i] > a[i - 1]) {
				end = a[i];
			} else {
				sum += end - start;
				start = a[i];
				end = a[i];
			}
		}
		sum += end - start;
		return sum;
	}
}
