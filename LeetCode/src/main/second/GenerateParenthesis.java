package second;

import java.util.ArrayList;
import java.util.HashMap;

public class GenerateParenthesis {
    public ArrayList<String> generateParenthesis(int n) {
        HashMap<Integer, ArrayList<String>> map = new HashMap<Integer, ArrayList<String>>();
        return generate(n, map);
    }
    
    private ArrayList<String> generate(int n, HashMap<Integer, ArrayList<String>> map){
        if(map.get(n) != null){
            return map.get(n);
        }
        
        ArrayList<String> r = new ArrayList<String>();
        if(n == 0){
            r.add("");
            return r;
        }
        for(int i=0;i<n;i++){
            ArrayList<String> left = generate(i, map);
            ArrayList<String> right = generate(n-1-i, map);
            for(String s : left){
                for(String t: right){
                    r.add("(" + s + ")" + t);
                }
            }
        }
        map.put(n, r);
        return r;
    }
}
