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
        if(n == 0) return -1;

        int[] remains = new int[n*2];
        for(int i=0;i<n*2;i++){
            int index = i%n;
            remains[i] = gas[index] - cost[index];
        }

        int[] sum = new int[n*2];
        sum[0] = remains[0];
        int pos = 0;

        for(int i=1;i<n*2;i++) {
            if(sum[i-1] >= 0) {
                sum[i] = sum[i - 1] + remains[i];
            } else {
                sum[i] = remains[i];
                pos = i;
            }
            // Reach the end that still has gas, return the starting point
            if(sum[i] >= 0 && (i-pos+1) >= n) {
                return pos;
            }
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
