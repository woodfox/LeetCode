package third;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

 For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.
 */
public class PerfectSquares {
    Map<Integer, Integer> map = new HashMap();

    /**
     * Time: O(n)?
     */
    public int numSquares(int n) {
        if(n == 0) return 0;
        else if(map.containsKey(n)) return map.get(n);

        int i=1;
        while((i+1)*(i+1) <= n) {
            i++;
        }

        int min = Integer.MAX_VALUE;
        while(i >= 1){
            int r = numSquares(n-i*i) + 1;
            min = Math.min(min, r);
            i--;
        }

        map.put(n, min);
        return min;
    }

    public int numSquares_recur(int n) {
        if(n == 0) return 0;
        else if(map.containsKey(n)) return map.get(n);

        int i=2;
        int min = n;
        while(i*i <= n){
            int a = n/(i*i);
            int b = n%(i*i);
            int r = a + numSquares(b);
            min = Math.min(min, r);
            i++;
        }

        map.put(n, min);
        return min;
    }

    // All numbers can construct with 4 square numbers
    // Time: O(sqrt(n))
    public int numSquares_fast(int n) {
        while(n%4 == 0) n /= 4;
        // Don't know how to prove that
        if(n%8 == 7) return 4;

        int min = n;
        for(int i=2;i*i<=n;i++){
            int j = (int)Math.sqrt(n-i*i);
            if(i*i + j*j == n) {
                if(j==0) return 1;
                else return 2;
            }
        }

        // Otherwise 3
        return 3;
    }

    /**
     * DP version to calculate min numbers.
     * Time: O(kn), k = sqrt(n)
     */
    public int numSquares_dp(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;

        for(int i=0;i<n;i++){
            dp[i] = Integer.MAX_VALUE;
        }

        for(int i=0;i<n;i++){
            for(int j=1;i+j*j<=n;j++){
                dp[i+j*j] = Math.min(dp[i+j*j], dp[i]+1);
            }
        }
        return dp[n];
    }
}
