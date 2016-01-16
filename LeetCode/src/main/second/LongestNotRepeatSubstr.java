package second;

public class LongestNotRepeatSubstr {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        boolean[] dp = new boolean[26];
        int i = 0;
        int j = 0;
        while(j < s.length()){
            if(dp[s.charAt(j) - 'a']){
                break;
            }
            dp[s.charAt(j) - 'a'] = true;
            j++;
        }
        int max = 0;
        while(i < j){
            max = Math.max(max, j-i);
            dp[s.charAt(i)-'a'] = false;
            i++;
            while(j < s.length()){
                char c = s.charAt(j);
                if(dp[c - 'a']){
                    break;
                }
                dp[c - 'a'] = true;
                j++;
            }
        }
        return max;
    }
}
