package third;

public class GasStation {
    /**
     * Use DP to improve performance.
     *
     * sum(i),pos = | sum(i-1) + a[i], pos   if f[i-1] >= 0
     *                 | a[i], i  else
     *
     * Time: O(n)
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        if(n==0) return -1;
        int remains = gas[0] - cost[0];
        int pos = 0;
        for(int i=1;i<2*n;i++){
            int j = i%n;
            if(remains >= 0) {
                remains += gas[j] - cost[j];
            } else {
                remains = gas[j] - cost[j];
                // Reset the position
                pos = i;
            }

            if(remains >=0 && i-pos>=n) return pos;
        }
        return -1;
    }

    // Time: O(n^2)   Time limited exceeded!
    public int canCompleteCircuit_slow(int[] gas, int[] cost) {
        int n = gas.length;
        if(n == 0) return -1;

        for(int i=0;i<n;i++){
            int remaining = 0;

            boolean flag = true;
            for(int pos=0;pos<n;pos++){
                int j = (i+pos)%n;
                remaining += (gas[j] - cost[j]);

                if(remaining < 0) {
                    flag = false;
                    break;
                }
            }

            if(flag) {
                return i;
            }
        }

        return -1;
    }
}
