package third;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartition {
    // Use DP to pre-calculate palindrome mapping for performance
    // Time in worst case: f(n) = f(n-1) + f(n-2) + ... = O(2^n)
    public List<List<String>> partition_dp(String s) {
        List<List<String>> result = new ArrayList<List<String>>();

        if(s == null || s.length() == 0) {
            return result;
        }

        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for(int length=0;length<n;length++){
            for(int i=0;i+length<n;i++){
                int j = i + length;
                if(i==j){
                    dp[i][j] = true;
                } else if(j == i+1){
                    dp[i][j] = (s.charAt(i) == s.charAt(j));
                } else {
                    dp[i][j] = dp[i+1][j-1] && (s.charAt(i) == s.charAt(j));
                }
            }
        }

        List<String> sub = new ArrayList<String>();
        backtrack(s, 0, dp, sub, result);
        return result;
    }

    private void backtrack(String s, int pos, boolean[][] dp, List<String> sub, List<List<String>> result) {
        if(pos >= s.length()) {
            result.add(new ArrayList<String>(sub));
        } else {
            for(int i=pos;i<s.length();i++){
                if(dp[pos][i]) {
                    String prefix = s.substring(pos, i+1);
                    sub.add(prefix);
                    backtrack(s, i+1, dp, sub, result);
                    sub.remove(prefix);
                }
            }
        }
    }

    // Iterate all partitions. Would need performance improvement.
    // Time: O(2^n)
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<List<String>>();

        if(s == null) {
            return result;
        } else if(s.length() == 0) {
            result.add(new ArrayList());
            return result;
        }

        for(int i=1;i<=s.length();i++){
            String prefix = s.substring(0, i);
            if(isPalindrome(prefix)) {
                for(List<String> sub : partition(s.substring(i))) {
                    sub.add(0, prefix);
                    result.add(sub);
                }
            }
        }

        return result;
    }

    private boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length()-1;
        while(start < end) {
            if(s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }
}
