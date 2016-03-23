package third;

import java.util.Arrays;

public class ScrambleString {
    /**
     * Loop the separate point and iterate all possibilities.
     *
     * Time Complexity:
     * f(n) = Sum(2(f(i) + f(n-i))), i = 1..n-1
     *      = O(4^n)?
     *
     * Should use int[256] to count characters and compare if string are similar, which is better than toCharArray and sort.
     */
    public boolean isScramble(String s1, String s2) {
        if(s1 == null || s2 == null || s1.length() != s2.length()) return false;

        if(s1.equals(s2)) return true;

        if(!checkCharacters(s1, s2)) return false;

        int n = s1.length();
        for(int i=1;i<n;i++){
            String left1 = s1.substring(0, i);
            String right1 = s1.substring(i);
            String left2 = s2.substring(0, i);
            String right2 = s2.substring(i);
            if(isScramble(left1, left2) && isScramble(right1, right2)) return true;

            String left3 = s2.substring(0, n-i);
            String right3 = s2.substring(n-i);

            if(isScramble(left1, right3) && isScramble(right1, left3)) return true;
        }
        return false;
    }

    private boolean checkCharacters(String s1, String s2) {
        String t1 = toSortedString(s1);
        String t2 = toSortedString(s2);
        return t1.equals(t2);
    }

    private String toSortedString(String s){
        char[] a = s.toCharArray();
        Arrays.sort(a);
        return new String(a);
    }
}
