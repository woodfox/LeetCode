package third;

/**
 *            | 1   if n == t.length
 * f(m, n) =  | 0   if m == s.length
 *            | f(m+1, n) + (f(m+1,n+1) if s[m] == t[n)
 *
 * m, n is the positions in S,T
 *
 */
public class DistinctSequences {
    public int numDistinct(String s, String t) {
        if(s == null || t == null) {
            return 0;
        }

        int m = s.length();
        int n = t.length();
        int[][] dp = new int[m+1][n+1];
        for(int i=m;i>=0;i--) {
            for(int j=n;j>=0;j--) {
                if(j == n) {
                    dp[i][j] = 1;
                }else if(i == m) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i+1][j];
                    if(s.charAt(i) == t.charAt(j)) {
                        dp[i][j] += dp[i+1][j+1];
                    }
                }
            }
        }

        return dp[0][0];
    }

}
