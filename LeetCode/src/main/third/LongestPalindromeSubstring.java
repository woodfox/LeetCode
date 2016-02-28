package third;

public class LongestPalindromeSubstring {
    /**
     * Manacher's algorithm to find longest palindrome substring (http://www.felix021.com/blog/read.php?2040).
     *
     * Time: O(n)
     */
    public int longestPalindromeSubstring(String s) {
        if (s == null || s.length() == 0) return 0;

        StringBuffer sb = new StringBuffer();
        for (char c : s.toCharArray()) {
            sb.append("#");
            sb.append(c);
        }
        sb.append("#");

        int n = sb.length();
        int[] p = new int[n];

        int id = -1;
        int max = -1;
        int longest = -1;
        for (int i = 0; i < n; i++) {
            p[i] = 1;
            if (max > i) {
                int j = 2 * id - i;
                p[i] = Math.min(p[j], max - i);
            }

            while (i + p[i] < n && i - p[i] >= 0 && sb.charAt(i + p[i]) == sb.charAt(i - p[i])) {
                p[i]++;
            }

            if (i + p[i] > max) {
                id = i;
                max = i + p[i];
            }

            longest = Math.max(longest, p[i]);
        }

        return longest - 1;
    }

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
