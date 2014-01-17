package second;

public class BuySellIII {
	public int maxProfit(int[] a) {
		if (a == null || a.length <= 1) {
			return 0;
		}

		int n = a.length;
		int[] first = new int[n];
		int[] second = new int[n];
		int min = a[0];
		int max = a[n - 1];
		first[0] = 0;
		second[n - 1] = 0;
		for (int i = 1; i < n; i++) {
			first[i] = Math.max(first[i - 1], a[i] - min);
			min = Math.min(min, a[i]);
		}
		for (int i = n - 2; i >= 0; i--) {
			second[i] = Math.max(second[i + 1], max - a[i]);
			max = Math.max(max, a[i]);
		}

		int sum = first[n - 1];
		for (int i = 1; i < n - 2; i++) {
			sum = Math.max(sum, first[i] + second[i + 1]);
		}
		return sum;
	}
}
