package third;

/**
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.

 For example:

 1 -> A
 2 -> B
 3 -> C
 ...
 26 -> Z
 27 -> AA
 28 -> AB
 */
public class ExcelColumnTitle {
    /**
     * Convert Integer to 26-based character string
     * Convert to 0-based index!!
     *
     * Be careful:
     *  1. should use 0-based index
     *  2. it may be AAAAAAB
     */
    public String convertToTitle(int n) {
        if(n < 1) {
            return "";
        }

        // index starting from 0
        n--;
        return convert(n);
    }

    private String convert(int n) {
        StringBuffer sb = new StringBuffer();
        int pos = n/26;
        if(pos > 0) {
            // Pos may be greater than 26!! Need to call recursively!
            sb.append(convert(pos-1));
            n = n%26;
        }

        int remain = n%26;
        sb.append((char)('A' + remain));
        return sb.toString();
    }
}
