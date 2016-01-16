package third;

import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddress {
    /**
     * 100,100,100,100
     *
     * Time Complexity:  Find 3 break points in n-2 positions.
     *   C(3)/(n-2) = (n-2)! / (3! (n-5)! = O(n^3)
     */
    public List<String> restoreIpAddresses(String s) {
        List<String> subset = new ArrayList<String>();
        List<String> result = new ArrayList<String>();
        if(s == null || s.length() == 0) return result;

        backtrack(s, 0, subset, result);
        return result;
    }

    private void backtrack(String s, int pos, List<String> subset, List<String> result) {
        int n = s.length();
        if(subset.size() == 4) {
            if(pos == n) {
                result.add(subset.get(0) + "." + subset.get(1) + "." + subset.get(2) + "." + subset.get(3));
            }
        }else if(pos < n){
            for(int i=pos+1;i<=pos+3&&i<=n;i++){
                String substr = s.substring(pos, i);

                if(Integer.parseInt(substr) <= 255){
                    subset.add(substr);
                    backtrack(s, i, subset, result);
                    subset.remove(subset.size()-1);
                }

                // If it starts with 0, it only allow itself to added (01 is not valid integer)
                if(s.charAt(pos) == '0') break;
            }
        }
    }
}
