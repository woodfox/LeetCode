package third;

import java.util.LinkedList;

public class CoinChange {
    /**
     * Can not use the greedy algorithm! The result may not be the best one. E.g, [1,2,6] result may be 3 instead of 2.
     *
     * dp[n] = min(dp[n-x] + 1), if n>=x && dp[n-x] != -1
     *
     * Time: O(n*k)
     */
    public int coinChange(int[] coins, int t) {
        int[] dp = new int[t+1];
        dp[0] = 0;
        for(int i=1;i<=t;i++){
            int r = Integer.MAX_VALUE;
            for(int x: coins) {
                if(i>=x && dp[i-x] != -1) {
                    r = Math.min(r, dp[i-x] + 1);
                }
            }
            if(r != Integer.MAX_VALUE) dp[i] = r;
            else dp[i] = -1;
        }

        return dp[t];
    }

    /**
     * Very interesting way:
     * BFS to see when we can reach the target or not.
     *
     * Time: O(n*k), k is total coins
     */
    public int coinChange_bfs(int[] coins, int t) {
        LinkedList<int[]> q = new LinkedList();
        q.add(new int[]{0,0});

        while(!q.isEmpty()) {
            int[] a = q.removeFirst();
            if(a[0] == t) return a[1];
            else if(a[0] < t) {
                for(int x: coins) {
                    q.add(new int[] {a[0]+x, a[1]+1});
                }
            }
        }
        return -1;
    }
}
