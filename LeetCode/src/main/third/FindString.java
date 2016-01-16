package third;

public class FindString {
    //Try brute force with O(m*n)
    public int strStrBruteForce(String haystack, String needle) {
        if (haystack == null || needle == null || needle.length() == 0) return -1;

        int m = haystack.length();
        int n = needle.length();
        for (int i = 0; i <= m - n; i++) {
            boolean flag = true;
            for (int j = 0; j < n; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return i;
            }
        }

        return -1;
    }

    /**
     * Try KMP with O(m+n)
     *
     * If current character is equal to the previous pos + 1, then increase pos;
     * otherwise rollback to the last position of same character using prefix pattern
     * and compare again.
     */
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null || needle.length() == 0) return -1;

        int[] pattern = initPattern(needle);
        int m = haystack.length();
        int n = needle.length();
        //pos is the last matched character
        int pos = -1;
        for(int i=0;i<m;i++){
            char c = haystack.charAt(i);
            while(pos >= 0){
                if(c != needle.charAt(pos+1)){
                    pos = pattern[pos];
                }else{
                    break;
                }
            }

            if(c == needle.charAt(pos+1)){
                pos++;
            }

            if(pos >= n-1){
                return i-(n-1);
            }
        }

        return -1;
    }

    // Initialize prefix pattern
    // E.g, "a b a b a c d" is with pattern [-1,-1,0,1,2,-1,-1]
    private int[] initPattern(String s) {
        int n = s.length();
        int[] pattern = new int[n];

        pattern[0] = -1;
        int pos = -1;
        for(int i=1;i<n;i++){
            while(pos >= 0){
                if(s.charAt(i) != s.charAt(pos+1)){
                    pos = pattern[pos];
                }else{
                    break;
                }
            }

            if(s.charAt(i) == s.charAt(pos+1)) {
                pos++;
            }
            pattern[i] = pos;
        }

        return pattern;
    }
}
