package second;

import java.util.ArrayList;

public class Triangle {
	public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
		if (triangle == null || triangle.size() == 0) {
			return 0;
		}

		int n = triangle.size();
		int[] dp = new int[n];
		dp[0] = triangle.get(0).get(0);
		for (int i = 1; i < n; i++) {
			for (int j = i; j >= 0; j--) {
				if (j == i) {
					dp[j] = dp[j - 1] + triangle.get(i).get(j);
				} else if (j == 0) {
					dp[j] = dp[j] + triangle.get(i).get(j);
				} else {
					dp[j] = Math.min(dp[j - 1], dp[j]) + triangle.get(i).get(j);
				}
			}
		}

		int min = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			min = Math.min(min, dp[i]);
		}
		return min;
	}
}
