package third;

public class MinPathes {
    /**
     * Assume all numbers in range [1, miss) can be got from arrays, then:
     *   1. if a[i]<=miss,  increase the reachable range to [1, miss+a[i]]
     *   2. otherwise need to add miss into array, and increase range to [1, miss*2]
     *
     * Time: O(n)
     */
    public int minPatches(int[] a, int n) {
        int m = a.length;
        long miss = 1;
        int i=0;
        int added = 0;
        while(miss<=n){
            if(i<m && a[i]<=miss) {
                // Can reach to miss+a[i]
                miss += a[i++];
            } else {
                // Add missing number
                added++;
                miss += miss;
            }
        }
        return added;
    }

    /**
     * Add non-visited position into patch list and add new sums for existing sum.
     * Would overflow if n is MAX INT
     *
     * Time: O(2^m + n^2)  m is array length
     */
    public int minPatches_slow(int[] a, int n) {
        int m = a.length;
        boolean[] b = new boolean[n+1];

        for(int i=1;i<(1<<m);i++) {
            long sum = 0;
            for(int j=0;j<m;j++){
                if((i&(1<<j)) != 0) sum += a[j];
            }

            if(sum<=n) b[(int)sum] = true;
        }

        int count = 0;
        for(int i=1;i<=n;i++){
            if(!b[i]) {
                // Add i into the patch list and add new sums for all existing sum
                count++;
                for(int j=1;j<=n;j++){
                    long sum = (long)i+j;
                    if(b[j] && sum<=n) b[(int)sum] = true;
                }

                b[i] = true;
            }
        }

        return count;
    }
}
