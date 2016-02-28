package third;

public class ReverseWords {
    /**
     * It needs to remove extra spaces between words.
     */
    public String reverseWords(String s) {
        if(s == null) {
            return s;
        }

        // Trim spaces to make sure it's not empty string except space
        s = s.trim();
        if(s.length() == 0) {
            return s;
        }

        String[] array = s.split(" ");
        int start = 0;
        int end = array.length - 1;
        while(start < end) {
            String tmp = array[start];
            array[start] = array[end];
            array[end] = tmp;

            start++;
            end--;
        }

        StringBuffer sb = new StringBuffer();
        for(String t : array) {
            if(t.length() > 0) {
                sb.append(t + " ");
            }
        }
        return sb.substring(0, sb.length()-1);
    }
}
