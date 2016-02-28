package third;

public class PalindromePartitionII {
    /**
     * Only calculate the min cuts if prefix (i,j) is palindrome.
     *
     * f(i) = min(f(j) + 1) if s(i, j) is palindrome
     *
     * Time: O(n^2)
     */
    public int minCut(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }

        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for(int length=0;length<n;length++){
            for(int i=0;i+length<n;i++){
                int j = i + length;
                if(s.charAt(i) == s.charAt(j)) {
                    if (j <= i + 1) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
            }
        }

        int[] minCuts = new int[n];
        // Have to initialize the cuts in worse case for each character!!
        for(int i=0;i<n;i++){
            minCuts[i] = n-i-1;
        }

        for(int i=n-1;i>=0;i--){
            for(int j=i;j<n;j++) {
                if(dp[i][j]){
                    if(j+1 >= n){
                        // prefix (i,n-1) is palindrome
                        minCuts[i] = 0;
                    } else {
                        minCuts[i] = Math.min(minCuts[i], minCuts[j+1]+1);
                    }
                }
            }
        }
        return minCuts[0];
    }

    //-------------------------------------------------------------------
    /**
     *            | 0   if s(i, j) is palindrome
     * f(i, j) =  | min(f(i, k), f(k+1, j)) + 1,    (i <= k < j)
     *
     * Time: O(n^3)
     */
    public int minCut_slow(String s) {
        if(s == null || s.length() == 0) {
            return 0;
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

        int[][] cuts = new int[n][n];
        for(int length=0;length<n;length++){
            for(int i=0;i+length<n;i++){
                int j = i+length;
                if(dp[i][j]) {
                    cuts[i][j] = 0;
                } else {
                    cuts[i][j] = Integer.MAX_VALUE;
                    for(int k=i;k<j;k++){
                        // total cuts in left, right and this one
                        int sum = cuts[i][k] + cuts[k+1][j] + 1;
                        cuts[i][j] = Math.min(cuts[i][j], sum);
                    }
                }
            }
        }

        return cuts[0][n-1];
    }
}
