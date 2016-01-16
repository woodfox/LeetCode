package third;

public class LongestPalindromeSubstring {
    /**
     * Can be solved by DP as well, but the performance is same as O(n^2)
     */
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0) return "";
        int n = s.length();
        String longest = "";
        for(int i=0;i<n;i++){
            String s1 = findPalindrome(s, i, i);
            String s2 = findPalindrome(s, i, i+1);
            if(longest.length() < s1.length()){
                longest = s1;
            }
            if(longest.length() < s2.length()){
                longest = s2;
            }
        }
        return longest;
    }

    private String findPalindrome(String s, int left, int right) {
        int n = s.length();
        while(left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        left++;
        right--;

        if(left < 0 || right >= n){
            return "";
        }else{
            return s.substring(left, right+1);
        }
    }
}
