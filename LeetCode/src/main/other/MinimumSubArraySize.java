package other;

public class MinimumSubArraySize {
    public int minimumSize(int[] a, int t) {
        int n = a.length;
        if (n == 0) return -1;
        int[] sum = new int[n + 1];
        sum[0] = 0;
        for (int i = 0; i < n; i++) sum[i + 1] = sum[i] + a[i];

        int l = 0;
        int r = 1;
        int len = Integer.MAX_VALUE;
        while (r <= n) {
            if(sum[r]-sum[l]>=t){
                len = Math.min(len, r-l);
            }

            if(sum[r]-sum[l]>=t){
                l++;
            }else{
                r++;
            }
        }
        if(len == Integer.MAX_VALUE) return -1;
        else return len;
    }

    public int minimumSize_complex(int[] a, int t) {
        int n = a.length;
        if(n==0) return -1;
        int[] sum = new int[n+1];
        sum[0] = 0;
        for(int i=0;i<n;i++) sum[i+1] = sum[i]+a[i];

        int l = 0;
        int r = 1;
        int len = Integer.MAX_VALUE;
        while(r<=n){
            // Move right side to satisfy sum>=t
            while(r<=n && sum[r]-sum[l]<t){
                r++;
            }
            if(r>n) break;

            // Move left side to minimize length
            while(sum[r]-sum[l+1]>=t){
                l++;
            }
            len = Math.min(len, r-l);

            // At last move left to break the condition
            l++;
        }
        if(len == Integer.MAX_VALUE) return -1;
        else return len;
    }
}
