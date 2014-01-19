package second;

import java.util.LinkedList;

public class SimplifyPath {
    public String simplifyPath(String s) {
        if(s == null){
            return null;
        }
        
        String[] a = s.split("/");
        LinkedList<String> q = new LinkedList<String>();
        for(String t : a){
            if(t == null || t.length() == 0|| t.equals(".")){
                continue;
            }
            if(t.equals("..")){
            	//Can only remove when not empty!!
                if(!q.isEmpty()){
                    q.removeLast();
                }
            }else{
                q.add(t);
            }
        }
        
        if(q.isEmpty()){
            return "/";
        }
        
        StringBuffer sb = new StringBuffer();
        for(String t:q){
            sb.append("/" + t);
        }
        return sb.toString();
    }
}
