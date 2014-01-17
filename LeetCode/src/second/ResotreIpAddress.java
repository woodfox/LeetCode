package second;

import java.util.ArrayList;

public class ResotreIpAddress {
    public ArrayList<String> restoreIpAddresses(String s) {
        ArrayList<String> r = new ArrayList<String>();
        if(s == null || s.length() == 0){
            return r;
        }
        
        ArrayList<Integer> sub = new ArrayList<Integer>();
        backtrack(s, 0, sub, r);
        return r;
    }
    
    void backtrack(String s, int p, ArrayList<Integer> sub, ArrayList<String> r){
        int n = s.length();
        if(sub.size() == 4){
            if(p >= n) {
                r.add(sub.get(0) + "." + sub.get(1) + "." + sub.get(2) + "." + sub.get(3));
            }
            return;
        }

        for(int i=0;i<3 && p+i < n; i++){
            int x = Integer.parseInt(s.substring(p, p+i+1));
            if(x < 256){
                sub.add(x);
                backtrack(s, p+i+1, sub, r);
                sub.remove(sub.size()-1);
            }
            if(s.charAt(p) == '0'){
                //Only use single number if starting with 0
                break;
            }
        }
    }
    
    public static void main(String[] args){
    	ResotreIpAddress r = new ResotreIpAddress();
    	System.out.println(r.restoreIpAddresses("2736786374048"));
    }
}
