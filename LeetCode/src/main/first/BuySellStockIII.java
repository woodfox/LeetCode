package first;

public class BuySellStockIII {
	//Scan the array only once to get max profit from 0...i and i+1...n-1
	//Time complexity is O(n)
	public int maxProfit(int[] p) {
		int n = p.length;
		if(n <=1) {
			return 0;
		}
		int maxProfit = 0;
		int[] a = new int[n];
		a[0] = 0;
		int min = p[0];
		for(int i=1;i<n;i++){
			if(p[i] - min > maxProfit){
				maxProfit = p[i] - min;
			}
			a[i] = maxProfit;
			
			if(p[i] < min){
				min = p[i];
			}
		}
		
		int result = a[n-1];
		int max = p[n-1];
		maxProfit = 0;
		for(int i=n-2;i>0;i--){
			if(max - p[i] > maxProfit){
				maxProfit = max - p[i];
			}
			if(p[i] > max){
				max = p[i];
			}
			if(a[i-1] + maxProfit > result){
				result = a[i-1] + maxProfit;
			}
		}
		return result;
	}
	
	//Divide and Conqueue with O(n^2)
	public int maxProfit2(int[] p) {    
		int n = p.length;
		int max = 0;
		for(int i=0;i<=n-1;i++){
			int sum = oneTransaction(p, 0, i)
				+ oneTransaction(p, i+1, n-1);
			if(sum > max){
				max = sum;
			}
		}
		return max;
	}
	
	int oneTransaction(int[] p, int start, int end){
		if (start > end) {
			return 0;
		}
		int maxProfit = 0;
		int min = p[start];
		int max = p[start];
		for(int i=start+1;i<=end;i++){
			if(p[i] > max){
				max = p[i];
			}else if(p[i] < min){
				if(maxProfit < max - min){
					maxProfit = max - min;
				}
				min = p[i];
				max = p[i];
			}
		}
		if(maxProfit < max - min){
			maxProfit = max - min;
		}
		return maxProfit;
		
	}
	 
    public static void main(String[] args) {
    	BuySellStockIII v = new BuySellStockIII();
    	
    	int[] a = {1};
    	System.out.println("Excepted 0:" + v.maxProfit(a));
    	
    	int[] b = {10, 13, 16};
    	System.out.println("Excepted 6:" + v.maxProfit(b));
    	
    	int[] c = {10, 13, 12, 7, 8, 6, 10};
    	System.out.println("Excepted 7:" + v.maxProfit(c));
    	
    	int[] d = {18, 16, 14, 12, 11, 10};
    	System.out.println("Excepted 0:" + v.maxProfit(d));
    	
    	int[] f = {10, 10, 10};
    	System.out.println("Excepted 0:" + v.maxProfit(f));
    	
    	int[] g = {4, 6, 8, 10, 9, 7, 5,9,11, 2};
    	System.out.println("Excepted 12:" + v.maxProfit(g));
    	
    	int[] h = {4, 6, 8, 10, 9, 7, 5,9,11, 2, 8, 11, 1};
    	System.out.println("Excepted 16:" + v.maxProfit(h));
    	
    	int[] i = {4, 6, 8, 10, 9, 7, 5,9,11, 2, 8, 11, 1, 3, 4, 5};
    	System.out.println("Excepted 16:" + v.maxProfit(i));
    	
    	int[] j = {1, 5, 7, 4, 3, 2, 4, 2, 1, 8, 9};
    	System.out.println("Excepted 14:" + v.maxProfit(j));
    	
    	int[] k = {1, 2,3,4,5,6,7,8,9,10,1};
    	System.out.println("Excepted 9:" + v.maxProfit(k));
    }
}
