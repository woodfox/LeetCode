package third;

public class DecodeWays {
    /**
     * f(i) = | 1  if i == n
     *        | 0  if s(i) = '0'
     *        | 1  if i == n-1
     *        | f(i+1) + f(i+2)[if s(i,i+1) <= 26]
     *
     * Time Complexity: O(n)
     */
    public int numDecodings(String s) {
        if(s == null || s.length() == 0) return 0;

        int n = s.length();
        int[] dp = new int[n+1];
        dp[n] = 1;
        for(int i=n-1;i>=0;i--){
            int first = s.charAt(i) - '0';
            if(first == 0){
                dp[i] = 0;
            }else if(i == n-1){
                dp[i] = 1;
            }else {
                dp[i] = dp[i+1];
                int second = s.charAt(i+1) - '0';
                if(first*10 + second <= 26){
                    dp[i] += dp[i+2];
                }
            }
        }

        return dp[0];
    }

    /**
     * f(n) = | 1  if s.length == 0
     *        | 0  if s(0) == 0
     *        | 1  if s.length == 1
     *        | f(n-1) + f(n-2)[if s(0,1) <= 26]
     *
     * f(n) = f(n-1) + f(n-2)
     *      = 2*f(n-2) + f(n-3)
     *      = 3*f(n-3) + 2*f(n-4)
     *      = 5*f(n-4) + 3*f(n-5)
     *      = 8*f(n-5) + 5*f(n-6)
     *      ...
     *      = O(2^n)
     *
     * Limited Time Exceeded!
     */
    public int numDecodings_slow(String s) {
        // Important: for empty string, it should be 1!
        if(s == null) return 0;
        else if(s.length() == 0) return 1;

        int first = s.charAt(0) - '0';
        if(first == 0) return 0;
        else if(s.length() == 1) return 1;

        int second = s.charAt(1) - '0';
        int total = numDecodings(s.substring(1));
        if(first*10+second <= 26){
            total += numDecodings(s.substring(2));
        }

        return total;
    }
}
