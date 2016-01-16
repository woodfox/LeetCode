package first;
import java.util.HashSet;
import java.util.Set;


public class WordBreak {	
	//Accepted when enhanced to first check first string in dictionary.
	//For suffix, it could save all unmatched substring to avoid duplicate calculation.
    public boolean wordBreak(String s, Set<String> dict) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(s == null||s.length() == 0){
            return false;
        }
        
        Set<String> unMatched = new HashSet<String>();
        if(!withSameChar(s, dict)){
            return false;
        }
        
        return isWordBreak(s, dict, unMatched);
    }
    
    private boolean isWordBreak(String s, Set<String> dict, Set<String> unMatched){
        if(dict.contains(s)){
            return true;
        }else if(unMatched.contains(s)){
        	return false;
        }
        
        for(int i=1;i<s.length();i++){
            String l = s.substring(0, i);
            String r = s.substring(i);
            if(dict.contains(l) && wordBreak(r, dict)){
                return true;
            }
        }
        unMatched.add(s);
        return false;
    }
    
    private boolean withSameChar(String s, Set<String> dict){
        boolean[] chars = new boolean[256];
        for(String t : dict){
            for(int i=0;i<t.length();i++){
                chars[t.charAt(i)] = true;
            }
        }
        
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(!chars[c]){
                return false;
            }
        }
        return true;
    }
}
