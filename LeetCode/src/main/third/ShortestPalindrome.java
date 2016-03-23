package third;

/**
 * Given a string S, you are allowed to convert it to a palindrome by adding characters in front of it. Find and return the shortest palindrome you can find by performing this transformation.

 For example:

 Given "aacecaaa", return "aaacecaaa".

 Given "abcd", return "dcbabcd".
 */
public class ShortestPalindrome {
    /**
     * Find the longest palindrome starting from 0 using KMP
     *
     * E.g,  s#s' = abacd#dcaba, then find the max prefix length at last position(which is 3).
     *
     * Time: O(n)
     */
    public String shortestPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }

        StringBuffer sb = new StringBuffer(s);
        sb.reverse();
        String t = s+"#"+sb.toString();
        int[] p = calcPrefix(t);

        int n = s.length();
        // Prepend the non-match part in the beginning
        return sb.substring(0, n-p[p.length-1]) + s;
    }

    int[] calcPrefix(String t){
        int[] p = new int[t.length()];
        p[0] = 0;
        for(int i=1;i<p.length;i++) {
            int k = p[i-1];
            while(k > 0 && t.charAt(i) != t.charAt(k)) {
                k = p[k-1];
            }
            if(t.charAt(i) == t.charAt(k)) {
                p[i] = k + 1;
            } else {
                p[i] = k;
            }
        }
        return p;
    }

    /**
     * Find the longest palindrome starting from 0.  (Time Limit Exceeded)
     *
     * Time: O(n^2)
     */
    public String shortestPalindrome_slow(String s) {
        if(s == null || s.length() <= 1) {
            return s;
        }

        int n = s.length();
        int end = n-1;
        while(end > 0) {
            int i = 0;
            int j = end;
            while(i < j) {
                if(s.charAt(i) != s.charAt(j)) {
                    break;
                }
                i++;
                j--;
            }

            if(i >= j) {
                break;
            }
            end--;
        }

        // Return s if it's palindrome
        if(end == n-1) {
            return s;
        }

        StringBuffer sb = new StringBuffer();
        for(int i=n-1;i>end;i--) {
            sb.append(s.charAt(i));
        }
        sb.append(s);
        return sb.toString();
    }
}
