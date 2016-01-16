package second;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] a) {
        if(a == null || a.length == 0){
            return "";
        }
        int p = 0;
        while(true){
            boolean flag = true;
            char c = 0;
            for(String s : a){
                if(s == null || s.length() <= p){
                    flag = false;
                    break;
                }
                if(c == 0){
                    c = s.charAt(p);
                }
                else if(s.charAt(p) != c){
                    flag = false;
                    break;
                }
            }
            if(!flag){
                break;
            }
            p++;
        }
        
        if(p == 0){
            return "";
        }else{
            return a[0].substring(0, p);
        }
    }
}
