package first;
public class GasStation {
	public int canCompleteCircuit(int[] gas, int[] cost) {
		// Note: The Solution object is instantiated only once and is reused by
		// each test case.
		int sum = 0;
		int n = gas.length;
		if (n == 0) {
			return -1;
		}

		int start = n;
		int end = 0;
		while (end < start) {
			if (sum + gas[end] - cost[end] >= 0) {
				sum += gas[end] - cost[end];
				end++;
			} else {
				start--;
				sum += gas[start] - cost[start];
			}
		}
		if (sum >= 0) {
			return start % n;
		} else {
			return -1;
		}
	}
}
