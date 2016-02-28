package third;

/**
 * Given an input string, reverse the string word by word. A word is defined as a sequence of non-space characters. The input string does not contain leading or trailing spaces and the words are always separated by a single space.

 For example, Given s = "the sky is blue", return "blue is sky the". Could you do it in-place without allocating extra space?
 */
public class ReverseWordsII {
    /**
     * Q: s.length > 0 and doesn't start/end with space, and only one space between words
     * R: Words are reversed in place
     */
    public String reverse(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        StringBuffer sb = new StringBuffer(s);
        int n = s.length();
        swap(sb, 0, n - 1);

        int start = 0;
        while (start < n) {
            int pos = start;
            while (pos < n) {
                if (sb.charAt(pos) == ' ') {
                    break;
                }
                pos++;
            }

            // Need to swap even for last word(when pos = n)
            swap(sb, start, pos - 1);

            // Skip the space and go to next word
            start = pos + 1;
        }

        return sb.toString();
    }

    private void swap(StringBuffer sb, int start, int end) {
        while (start < end) {
            char c = sb.charAt(start);
            char d = sb.charAt(end);
            sb.setCharAt(start, d);
            sb.setCharAt(end, c);

            start++;
            end--;
        }
    }

    //--------------------------------------------------------
    // Simple way to swap string arrays
    public String reverse_simple(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        String[] array = s.split(" ");
        int start = 0;
        int end = array.length - 1;
        while (start < end) {
            String tmp = array[start];
            array[start] = array[end];
            array[end] = tmp;
        }

        StringBuffer sb = new StringBuffer();
        for (String t : array) {
            sb.append(t + " ");
        }

        return sb.substring(0, sb.length() - 1);
    }
}
