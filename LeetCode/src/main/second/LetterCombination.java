package second;

import java.util.ArrayList;

public class LetterCombination {
    public ArrayList<String> letterCombinations(String s) {
        ArrayList<String> r = new ArrayList<String>();
        if(s == null || s.length() == 0){
            return r;
        }
        String[] a = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ArrayList<Character> sub = new ArrayList<Character>();
        backtrack(s, sub, r, a);
        return r;
    }
    
    void backtrack(String s, ArrayList<Character> sub, ArrayList<String> r, String[] a){
        int n = s.length();
        int k = sub.size();
        if(k >= n){
            addResult(sub, r);
        }else{
            int p = s.charAt(k) - '2';
            String t = a[p];
            for(int i=0;i<t.length();i++){
                sub.add(t.charAt(i));
                backtrack(s, sub, r, a);
                sub.remove(sub.size()-1);
            }
        }
    }
    
    void addResult(ArrayList<Character> sub, ArrayList<String> r){
        StringBuffer sb = new StringBuffer();
        for(char c : sub){
            sb.append(c);
        }
        r.add(sb.toString());
    }
    
    public static void main(String[] args){
    	LetterCombination l = new LetterCombination();
    	System.out.println(l.letterCombinations("2"));
    }
}
