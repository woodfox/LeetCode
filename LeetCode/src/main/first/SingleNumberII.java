package first;
public class SingleNumberII {
	public int singleNumber(int[] a) {
		// Note: The Solution object is instantiated only once and is reused by
		// each test case.
		if (a == null || a.length == 0) {
			return -1;
		}

		int r = 0;
		int[] counts = new int[32];
		for (int i = 0; i < 32; i++) {
			for (int j = 0; j < a.length; j++) {
				int flag = (a[j] >> i) & 1;
				if (flag == 1) {
					counts[i] = (counts[i] + 1) % 3;
				}
			}

			if (counts[i] > 0) {
				r |= (1 << i);
			}
		}
		return r;
	}
}
