package second;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class WordBreakII {
    public ArrayList<String> wordBreak(String s, Set<String> dict) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        ArrayList<String> r = new ArrayList<String>();
        ArrayList<String> sub = new ArrayList<String>();
        if(s == null || s.length() == 0){
            return r;
        }
        
        Set<String> unmatch = new HashSet<String>();
        backtrack(s, dict, sub, r, unmatch);
        return r;
    }
    
    boolean backtrack(String s, Set<String> dict, ArrayList<String> sub, ArrayList<String> r, Set<String> unmatch){
    	if(unmatch.contains(s)){
    		return false;
    	}
    	
        int n = s.length();
        if(n == 0){
            addResult(sub, r);
            return true;
        }else{
        	boolean flag = false;
            for(int i=1;i<=n;i++){
                String left = s.substring(0, i);
                String right = s.substring(i);
                if(dict.contains(left)){
                    sub.add(left);
                    if(backtrack(right, dict, sub, r, unmatch)){
                    	flag = true;
                    }
                    sub.remove(sub.size()-1);
                }
            }
            if(!flag){
            	unmatch.add(s);
            }
            return flag;
        }
    }
    
    void addResult(ArrayList<String> sub, ArrayList<String> r){
        StringBuffer sb = new StringBuffer();
        for(String s: sub){
            sb.append(s + " ");
        }
        r.add(sb.substring(0, sb.length()-1));
    }
}
