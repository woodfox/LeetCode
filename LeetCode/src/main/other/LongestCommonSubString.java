package other;

/**
 * Find the longest common substring in two strings.
 */
public class LongestCommonSubString {
    // Time: O(n^2)  Space: O(n)
    public String longestCommonSubstr(String s, String t) {
        int m = s.length();
        int n = t.length();
        String r = "";
        int[][] dp = new int[m+1][n+1];
        for(int i=m;i>=0;i--){
            for(int j=n;j>=0;j--){
                if(i==m || j==n) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i+1][j+1];
                    if(s.charAt(i) == t.charAt(j)) dp[i][j]++;
                }
                if(dp[i][j]>r.length()){
                    r = s.substring(i, i+dp[i][j]);
                }
            }
        }

        return r;
    }

    /**
     * Use one-dimension array to save space
     *
     * Time: O(n^2),   Space: O(n)
     */
    public String longestCommonSubstr_lessSpace(String s, String t) {
        int m = s.length();
        int n = t.length();
        String r = "";
        int[] dp = new int[n+1];
        for(int i=m-1;i>=0;i--){
            int[] newDp = new int[n+1];
            for(int j=n-1;j>=0;j--){
                newDp[j] = dp[j+1];
                if(s.charAt(i) == t.charAt(j)) newDp[j]++;
                if(newDp[j]>r.length()){
                    r = s.substring(i, i+newDp[j]);
                }
            }
            dp = newDp;
        }

        return r;
    }
}
