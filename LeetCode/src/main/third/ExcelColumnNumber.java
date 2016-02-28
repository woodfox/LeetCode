package third;

/**
 * Related to question Excel Sheet Column Title

 Given a column title as appear in an Excel sheet, return its corresponding column number.

 For example:

 A -> 1
 B -> 2
 C -> 3
 ...
 Z -> 26
 AA -> 27
 AB -> 28
 */
public class ExcelColumnNumber {
    public int titleToNumber(String s) {
        if(s == null || s.length() == 0) {
            return -1;
        }

        int sum = 0;
        for(char c : s.toCharArray()) {
            int num = c - 'A' + 1;
            sum = sum*26 + num;
        }
        return sum;
    }
}
