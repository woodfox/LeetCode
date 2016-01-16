package second;

public class FindFirstMissingPositive {
    public int firstMissingPositive(int[] a) {
        int n = a.length;
        if(n == 0){
            return 1;
        }
        
        for(int i=0;i<n;i++){
            if(a[i] <= 0){
                a[i] = n+1;
            }
        }
        
        for(int i=0;i<n;i++){
        	int x = Math.abs(a[i]);
            if(x <= n){            	
                a[x-1] = Math.abs(a[x-1]) * -1;
            }
        }
        
        for(int i=0;i<n;i++){
            if(a[i] > 0){
                return i+1;
            }
        }
        return n+1;
    }
    
    public static void main(String[] args){
    	FindFirstMissingPositive f = new FindFirstMissingPositive();
    	int[] a = {2,1};
    	System.out.println(f.firstMissingPositive(a));
    }
}
