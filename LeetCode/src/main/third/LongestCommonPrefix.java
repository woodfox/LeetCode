package third;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0){
            return "";
        }

        int n = strs.length;
        String first = strs[0];
        int pos = 0;
        while(pos < first.length()) {
            char c = first.charAt(pos);
            boolean flag = true;
            for(int i=1;i<n;i++) {
                if(pos >= strs[i].length() || strs[i].charAt(pos) != c) {
                    flag = false;
                    break;
                }
            }

            if(flag){
                pos++;
            }else{
                break;
            }
        }

        return first.substring(0, pos);
    }
}
