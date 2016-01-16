package first;
public class CountUniqueBST {
	// Use Dynamic Programming to improve it
	// Time complexity is O(nZ^2), space is O(n)
	public int numTrees(int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int[] m = new int[n + 1];
		m[0] = 1;
		m[1] = 1;
		for (int i = 2; i <= n; i++) {
			m[i] = 0;
			for (int j = 0; j < i; j++) {
				m[i] += m[j] * m[i - j - 1];
			}
		}
		return m[n];
	}

	// Calculate number of left and right recursively
	// Time complexisity is O(?)
	public int numTrees2(int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		return count(1, n);
	}

	int count(int start, int end) {
		int sum = 0;
		if (start >= end) {
			return 1;
		}
		for (int i = start; i <= end; i++) {
			int left = count(start, i - 1);
			int right = count(i + 1, end);
			sum += left * right;
		}
		return sum;
	}
	
	public static void main(String[] args){
		CountUniqueBST c = new CountUniqueBST();
		System.out.println(c.numTrees(2));
	}
}
