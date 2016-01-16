package third;

import java.util.ArrayList;
import java.util.List;

public class LetterOfPhoneNumber {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<String>();
        if(digits == null) {
            return result;
        }

        String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        StringBuffer sb = new StringBuffer();
        backtrace(map, digits, 0, sb, result);

        return result;
    }

    private void backtrace(String[] map, String digits, int pos, StringBuffer sb, List<String> result) {
        if(pos >= digits.length()) {
            result.add(sb.toString());
            return;
        }

        int index = digits.charAt(pos) - '0';
        String s = map[index];
        for(int i=0;i<s.length();i++){
            sb.append(s.charAt(i));
            backtrace(map, digits, pos+1, sb, result);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
