package second;

public class TrapWater {
    public int trap(int[] a) {
        int n = a.length;
        if(n == 0){
            return 0;
        }
        
        int[] l = new int[n];
        l[0] = 0;
        for(int i=1;i<n;i++){
            l[i] = Math.max(l[i-1], a[i-1]);
        }
        
        int[] r = new int[n];
        r[n-1] = 0;
        for(int i=n-2;i>=0;i--){
            r[i] = Math.max(r[i+1], a[i+1]);
        }
        
        int sum = 0;
        for(int i=1;i<n-1;i++){
            int max = Math.min(l[i], r[i]);
            sum += Math.max(max - a[i], 0);
        }

        return sum;
    }
}
