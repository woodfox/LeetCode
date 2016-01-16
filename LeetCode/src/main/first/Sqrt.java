package first;
public class Sqrt {
	//StackOverflowError exception for binary Sqrt!!
	public int sqrt(int x) {
		// Start typing your Java solution below
		// DO NOT write main() function
		return binarySqrt(0, x, x);
	}

	int binarySqrt(int start, int end, int x) {
		if (start > end) {
			return -1;
		}
		int m = (start + end) / 2;
		long multiple = ((long)m) * ((long)m);
		long multiple2 = ((long)(m+1)) * ((long)(m+1));
		if (multiple <= (long)x && multiple2 > (long)x) {
			return m;
		} else if (multiple < x) {
			return binarySqrt(m + 1, end, x);
		} else {
			return binarySqrt(start, m - 1, x);
		}
	}
	
	public static void main(String[] args){
		Sqrt s = new Sqrt();
		System.out.println(s.sqrt(2999999));
	}
}
