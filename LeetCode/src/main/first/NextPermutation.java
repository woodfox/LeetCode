package first;
import java.util.Arrays;

public class NextPermutation {
	public void nextPermutation(int[] a) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int n = a.length;
		if (n <= 1) {
			return;
		}

		for (int i = 2; i <= n; i++) {
			int l = n - i;
			int min = Integer.MAX_VALUE;
			int p = -1;
			for (int j = l + 1; j < n; j++) {
				if (a[j] > a[l] && a[j] < min) {
					min = a[j];
					p = j;
				}
			}
			if (p != -1) {
				swap(a, l, p);
				sort(a, l + 1, n);
				return;
			}
		}
		Arrays.sort(a);
	}

	void swap(int[] a, int i, int j) {
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}

	void sort(int[] a, int start, int end) {
		Arrays.sort(a, start, end);
	}
	
	public static void main(String[] args){
		NextPermutation n = new NextPermutation();
		int[] a = {1,3,2};
		n.nextPermutation(a);
		System.out.println(Arrays.toString(a));
	}
}
