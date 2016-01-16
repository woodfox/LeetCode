package first;

public class BuySellStock {
	public int maxProfit(int[] p) {        
        //It will throw Time Limited error for O(n^2)
//		int max = 0;
//        for(int i=0;i<p.length-1;i++){
//        	for(int j=i+1;j<p.length;j++){
//        		if(p[j] - p[i] > max){
//        			max = p[j] - p[i];
//        		}
//        	}
//        }
		
		if (p == null || p.length <= 1) {
			return 0;
		}
		int maxProfit = 0;
        int max = p[0];
        int min = p[0];
        for(int i=1;i<p.length;i++){
        	if(p[i] > max) {
        		max = p[i];        		
        	}
        	else if(p[i] < min) {
        		if (maxProfit < max - min) {
        			maxProfit = max - min;
        		}
        		min = p[i];
        		max = p[i];
        	}
        }
        
        if (maxProfit < max - min) {
			maxProfit = max - min;
		}
        
        return maxProfit;
    }
	 
    public static void main(String[] args) {
    	BuySellStock v = new BuySellStock();
    	
    	int[] a = {1};
    	System.out.println("Excepted 0:" + v.maxProfit(a));
    	
    	int[] b = {10, 13, 16};
    	System.out.println("Excepted 6:" + v.maxProfit(b));
    	
    	int[] c = {10, 13, 12, 9, 8, 6, 10};
    	System.out.println("Excepted 4:" + v.maxProfit(c));
    	
    	int[] d = {18, 16, 14, 12, 11, 10};
    	System.out.println("Excepted 0:" + v.maxProfit(d));
    	
    	int[] f = {10, 10, 10};
    	System.out.println("Excepted 0:" + v.maxProfit(f));
    	
    	int[] g = {4, 6, 8, 10, 9, 7, 5,9,11, 2};
    	System.out.println("Excepted 7:" + v.maxProfit(g));
    	
    	int[] h = {4, 6, 8, 10, 9, 7, 5,9,11, 2, 8, 11, 1};
    	System.out.println("Excepted 9:" + v.maxProfit(h));
    	
    	int[] i = {4, 6, 8, 10, 9, 7, 5,9,11, 2, 8, 11, 1, 3, 4, 5};
    	System.out.println("Excepted 9:" + v.maxProfit(i));
    }
}
