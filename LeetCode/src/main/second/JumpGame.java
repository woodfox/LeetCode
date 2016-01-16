package second;

public class JumpGame {
    public boolean canJump(int[] a) {
        int n = a.length;
        if(n == 0){
            return false;
        }
        
        int i = 0;
        int j = 0;
        while(i <= j && j < n){
            int p = 0;
            for(int k=i;k<=j;k++){
                p = Math.max(p, k+a[k]);
            }
            i = j+1;
            j = p;
        }
        return (j >= n-1);
    }
    
    //TLE with O(n^2)
    public boolean canJump2(int[] a) {
        if(a.length == 0){
            return false;
        }
        
        int n = a.length;
        boolean[] dp = new boolean[n];
        dp[0] = true;
        for(int i=0;i<n-1;i++){
            if(dp[i]){
                for(int j=1;j<=a[i];j++){
                    if(i+j >= n){
                        break;
                    }
                    dp[i+j] = true;
                }
            }
        }
        return dp[n-1];
    }
}
