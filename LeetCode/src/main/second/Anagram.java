package second;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Anagram {
    public ArrayList<String> anagrams(String[] l) {
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        for(String s : l){            
            String t = sort(s);
            if(map.get(t) == null){
                map.put(t, new ArrayList<String>());
            }
            map.get(t).add(s);
        }
        ArrayList<String> r = new ArrayList<String>();
        for(ArrayList<String> sub : map.values()){
            if(sub.size() > 1){
                r.addAll(sub);
            }
        }
        return r;
    }
    
    String sort(String s){
        char[] a = s.toCharArray();
        Arrays.sort(a);
        return new String(a);
    }
}
