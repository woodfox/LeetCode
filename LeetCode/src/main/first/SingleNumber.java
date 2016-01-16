package first;
public class SingleNumber {
	public int singleNumber(int[] a) {
		// Note: The Solution object is instantiated only once and is reused by
		// each test case.
		if (a == null || a.length == 0) {
			return -1;
		}
		int r = a[0];
		for (int i = 1; i < a.length; i++) {
			r = r ^ a[i];
		}
		return r;
	}
}
