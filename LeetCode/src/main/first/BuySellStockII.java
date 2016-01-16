package first;

public class BuySellStockII {
	public int maxProfit(int[] p) {        
        int sum = 0;
        int i =0;
        while (i < p.length - 1){
            int j = i + 1;
            while(j< p.length && p[j] > p[j-1]){
                j++;
            }
            
            if(j == p.length || j > i+1){
            	j--;
            	sum += p[j] - p[i];
            	i = j+1;
            }
            else {
            	i = j;
            }
        }
        
        return sum;
    }
	 
    public static void main(String[] args) {
    	BuySellStockII v = new BuySellStockII();
    	
    	int[] a = {1};
    	System.out.println("Excepted 0:" + v.maxProfit(a));
    	
    	int[] b = {10, 13, 16};
    	System.out.println("Excepted 6:" + v.maxProfit(b));
    	
    	int[] c = {10, 13, 12, 9, 8, 6, 10};
    	System.out.println("Excepted 7:" + v.maxProfit(c));
    	
    	int[] d = {18, 16, 14, 12, 11, 10};
    	System.out.println("Excepted 0:" + v.maxProfit(d));
    	
    	int[] f = {10, 10, 10};
    	System.out.println("Excepted 0:" + v.maxProfit(f));
    	
    	int[] g = {4, 6, 8, 10, 9, 7, 5,9,11, 2};
    	System.out.println("Excepted 12:" + v.maxProfit(g));
    	
    	int[] h = {4, 6, 8, 10, 9, 7, 5,9,11, 2, 8, 11, 1};
    	System.out.println("Excepted 21:" + v.maxProfit(h));
    	
    	int[] i = {4, 6, 8, 10, 9, 7, 5,9,11, 2, 8, 11, 1, 3, 4, 5};
    	System.out.println("Excepted 25:" + v.maxProfit(i));
    	
    	int[] j = {1, 5, 7, 4, 3, 2, 4, 2, 1, 8, 9};
    	System.out.println("Excepted 16:" + v.maxProfit(j));
    }
}
