package third;

/**
 * Consider number and letters!
 */
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        if(s == null){
            return true;
        }

        String t = s.toLowerCase();
        int start = 0;
        int end = t.length() -1;
        while(start < end) {
            char left = t.charAt(start);
            char right = t.charAt(end);
            if(!isLetterOrNumber(left)) {
                start ++;
            } else if(!isLetterOrNumber(right)) {
                end --;
            } else {
                if(left != right) {
                    return false;
                }
                start ++;
                end --;
            }
        }

        return true;
    }

    private boolean isLetterOrNumber(char c) {
        return ((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9'));
    }
}
