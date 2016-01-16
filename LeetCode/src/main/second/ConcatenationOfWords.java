package second;

import java.util.ArrayList;
import java.util.HashMap;

public class ConcatenationOfWords {
    public ArrayList<Integer> findSubstring(String s, String[] l) {
        if(s == null || l == null||l.length==0||s.length()==0){
            return null;
        }
        
        int n =s.length();
        int m = l[0].length() * l.length;
        
        ArrayList<Integer> r = new ArrayList<Integer>();
        HashMap<String, Integer> map = count(l);
        for(int i=0;i<=n-m;i++){
            if(check(s.substring(i, i+m), l.length, map)){
                r.add(i);
            }
        }
        return r;
    }
    
    boolean check(String s, int n, HashMap<String, Integer> map){
        int m = s.length()/n;
        
        HashMap<String, Integer> count = new HashMap<String, Integer> ();
        for(int i=0;i+m<=s.length();i=i+m){
            String t = s.substring(i, i+m);
            if(count.get(t) == null){
            	count.put(t, 1);
            }else{
            	count.put(t, count.get(t)+1);
            }
            
            if(map.get(t) == null || map.get(t) < count.get(t)){
                return false;
            }
        }
        
        return true;
    }
    
    HashMap<String, Integer> count(String[] l){
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for(String s:l){
            if(map.get(s) == null){
                map.put(s, 1);
            }else{
                map.put(s, map.get(s)+1);
            }
        }
        return map;
    }
}
