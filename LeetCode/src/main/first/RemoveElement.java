package first;
public class RemoveElement {
	public int removeElement(int[] a, int v) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int i = 0;
		int j = a.length - 1;
		if (a.length == 0) {
			return 0;
		}
		while (i <= j) {
			if (a[i] == v) {
				if (i < j) {
					swap(a, i, j);
				}
				j--;
			} else {
				i++;
			}
		}

		return j + 1;
	}

	void swap(int[] a, int i, int j) {
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}
}
