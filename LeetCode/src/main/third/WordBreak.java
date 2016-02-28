package third;

import java.util.Set;

public class WordBreak {
    /**
     * Alway try to improve!
     * Enhanced DP to only calculate from starting point 0.
     * f(i) = | true   if s(0, i) is in dict
     *        | f(0, j) && s(j+1, i) is in dict,   0 <= j < i
     *
     *  Time: O(n^2)
     */
    public boolean wordBreak(String s, Set<String> wordDict) {
        if (s == null || s.length() == 0) {
            return true;
        }

        int n = s.length();
        boolean[] dp = new boolean[n];
        for(int i=0;i<n;i++) {
            if(wordDict.contains(s.substring(0, i+1))) {
                dp[i] = true;
            } else {
                for(int j=0;j<i;j++){
                    if(dp[j] && wordDict.contains(s.substring(j+1, i+1))) {
                        dp[i] = true;
                        break;
                    }
                }
            }
        }

        return dp[n-1];
    }

    /**
     * DP way.
     *
     *           | true if s(i, j) in dict
     * f(i, j) = | true if f(i, k) && f(k+1, j),   i <= k < j
     *           | false otherwise
     * (i <= j)
     *
     * Time: O(n^3)
     */
    public boolean wordBreak_dp(String s, Set<String> wordDict) {
        if (s == null || s.length() == 0) {
            return true;
        }

        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for(int length=0;length<n;length++){
            for(int i=0;i+length<n;i++){
                int j = i+length;

                if(wordDict.contains(s.substring(i, j+1))) {
                    dp[i][j] = true;
                } else {
                    for (int k = i; k < j; k++) {
                        if (dp[i][k] && dp[k+1][j]) {
                            dp[i][j] = true;
                            break;
                        }
                    }
                }
            }
        }

        return dp[0][n-1];
    }
    /**
     * Backtrack version with time O(2^n)
     */
    public boolean wordBreak_slow(String s, Set<String> wordDict) {
        if(s == null || s.length() == 0) {
            return true;
        }

        return backtrack(s, 0, wordDict);
    }

    private boolean backtrack(String s, int pos, Set<String> wordDict) {
        if(pos >= s.length()) {
            return true;
        } else {
            for(int i=pos;i<s.length();i++) {
                String t = s.substring(pos, i+1);
                if(wordDict.contains(t)) {
                    if(backtrack(s, i+1, wordDict)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }
}
