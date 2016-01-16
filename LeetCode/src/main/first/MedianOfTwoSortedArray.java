package first;

public class MedianOfTwoSortedArray {
	public static double findMedian(int[] a, int[] b){
		int m = a.length;
		int n = b.length;
		if(m == 0 && n == 0){
			return 0;
		}if((m+n)%2 == 1){
			return findKth(a, 0, m-1, b, 0, n-1, (m+n)/2+1);
		}else{
			return (double)(findKth(a, 0, m-1, b, 0, n-1, (m+n)/2)
			+ findKth(a, 0, m-1, b, 0, n-1, (m+n)/2+1))/2;
		}
	}
	
	public static int findKth(int[] a, int starta, int enda, 
			int[] b, int startb, int endb, int k){
		if(enda - starta > endb - startb){
			return findKth(b, startb, endb, a, starta, enda, k);
		}
		if(starta > enda){
			return b[startb + k-1];
		}else if(k == 1){
			return Math.min(a[starta], b[startb]);
		}
		
		int la = Math.min(k/2, enda-starta+1);
		int pa = starta + la;
		int pb = startb + k - la;
		if(a[pa-1] == b[pb-1]){
			return a[pa-1];
		}else if(a[pa-1] < b[pb-1]){
			return findKth(a, pa, enda, b, startb, pb-1, k-(pa-starta));
		}else{
			return findKth(a, starta, pa-1, b, pb, endb, k-(pb-startb));
		}
	}
	
	public static void main(String[] args){
		int[] a = {1, 3, 5, 7, 9};
		int[] b = {2, 4, 6, 8, 10, 12, 14, 16};
		System.out.println("1th Element 1:" + findKth(a, 0, 4, b, 0, 7, 1));
		System.out.println("2th Element 2:" + findKth(a, 0, 4, b, 0, 7, 2));
		System.out.println("3th Element 3:" + findKth(a, 0, 4, b, 0, 7, 3));
		System.out.println("4th Element 4:" + findKth(a, 0, 4, b, 0, 7, 4));
		System.out.println("1th Element 5:" + findKth(a, 0, 4, b, 0, 7, 5));
		System.out.println("1th Element 6:" + findKth(a, 0, 4, b, 0, 7, 6));
		System.out.println("1th Element 7:" + findKth(a, 0, 4, b, 0, 7, 7));
		System.out.println("1th Element 8:" + findKth(a, 0, 4, b, 0, 7, 8));
		System.out.println("1th Element 9:" + findKth(a, 0, 4, b, 0, 7, 9));
		System.out.println("1th Element 10:" + findKth(a, 0, 4, b, 0, 7, 10));
		System.out.println("1th Element 12:" + findKth(a, 0, 4, b, 0, 7, 11));
		System.out.println("1th Element 14:" + findKth(a, 0, 4, b, 0, 7, 12));
		System.out.println("1th Element 16:" + findKth(a, 0, 4, b, 0, 7, 13));
		
		System.out.println("Median: " + findMedian(a, b));
		

		int[] c = {1, 3, 5, 7, 9};
		int[] d = {2, 4, 6, 9, 10, 12, 14, 16, 18};
		System.out.println("Median: " + findMedian(d, c));
		
		int[] e = {};
		int[] f = {2,3};
		System.out.println("Median: " + findMedian(e, f));
	}
}
