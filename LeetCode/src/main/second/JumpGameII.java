package second;

public class JumpGameII {
    public int jump(int[] a) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int n = a.length;
        if(n == 0){
            return Integer.MAX_VALUE;
        }
        
        int i = 0;
        int j = 0;
        int steps = 0;
        while(i<=j && j<n-1){
            int p = 0;
            for(int k=i;k<=j;k++){
                p = Math.max(p, a[k]+k);
            }
            steps++;
            i = j+1;
            j = p;
        }
        if(j < n-1){
            return Integer.MAX_VALUE;
        }else{
            return steps;
        }
    }
}
