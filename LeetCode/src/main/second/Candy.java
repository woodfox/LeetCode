package second;

public class Candy {
	public int candy(int[] a) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(a == null || a.length == 0){
        	return 0;
        }
        
        int n = a.length;
        int[] left = new int[n];
        left[0] = 1;
        for(int i=1;i<n;i++){
            if(a[i] > a[i-1]){
                left[i] = left[i-1] + 1;
            }else{
                left[i] = 1;
            }
        }
        
        int[] right = new int[n];
        right[n-1] = 1;
        for(int i=n-2;i>=0;i--){
            if(a[i] > a[i+1]){
                right[i] = right[i+1] + 1;
            }else{
                right[i] = 1;
            }
        }
        
        int r = 0;
        for(int i=0;i<n;i++){
            r += Math.max(left[i], right[i]);
        }
        return r;
    }
}
