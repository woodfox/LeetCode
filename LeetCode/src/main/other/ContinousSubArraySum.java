package other;

import java.util.ArrayList;

public class ContinousSubArraySum {
    /**
     * Only use previous sum if it's positive
     *
     * dp[i] = max(dp[i-1], 0) + a[i]
     * startingPos[i] = |  startingPos[i-1] (if dp[i-1]>0)
     *                  |  i   otherwise
     */
    public ArrayList<Integer> continuousSubarraySum(int[] a) {
        int n = a.length;
        ArrayList<Integer> r = new ArrayList();
        if(n == 0) return r;

        int max = Integer.MIN_VALUE;
        int sum = 0;
        int[] startingPos = new int[n];
        for(int i=0;i<n;i++){
            if(sum > 0) {
                sum = sum + a[i];
                startingPos[i] = startingPos[i-1];
            } else {
                sum = a[i];
                startingPos[i] = i;
            }

            if(sum > max) {
                max = sum;
                r.clear();
                r.add(startingPos[i]);
                r.add(i);
            }
        }

        return r;
    }
}
