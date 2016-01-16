package second;

public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int n = gas.length;
        if(n == 0){
            return -1;
        }
        
        int[] a= new int[n];
        for(int i=0;i<n;i++){
            a[i] = gas[i] - cost[i];
        }
        
        int[] dp  = new int[n];
        dp[0] = a[0];
        int p = 0;
        for(int i=1;i<n;i++){
            if(dp[i-1] < 0){
                dp[i] = a[i];
                p = i;
            }else{
                dp[i] = dp[i-1] + a[i];
            }
        }
        
        int r = 0;
        int i = p;
        do{
            r += a[i];
            i = (i+1)%n;
            if(r < 0){
                return -1;
            }
        }while(i != p);
        return p;
    }
    
	//TLE with O(n^2)
    public int canCompleteCircuit2(int[] gas, int[] cost) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int n = gas.length;
        if(n == 0){
            return -1;
        }
        
        int[] a= new int[n];
        for(int i=0;i<n;i++){
            a[i] = gas[i] - cost[i];
        }
        for(int i=0;i<n;i++){
            int r = a[i];
            if(r <= 0){
                continue;
            }
            int j = i+1;
            while(j != i){
                j = j%n;
                r += a[j];
                if(r <= 0){
                    break;
                }
                j++;
            }
            if(j == i){
                return i;
            }
        }
        return -1;
    }
}
