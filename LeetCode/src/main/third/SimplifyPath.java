package third;

import java.util.LinkedList;

public class SimplifyPath {
    public String simplifyPath(String path) {
        LinkedList queue = new LinkedList();
        String[] array = path.split("/");
        for(String s : array){
            if(s.equals("") || s.equals(".")){
                continue;
            }else if(s.equals("..")){
                if(!queue.isEmpty()) queue.removeLast();
            }else{
                queue.addLast(s);
            }
        }

        StringBuffer sb = new StringBuffer();
        while(!queue.isEmpty()){
            sb.append("/");
            sb.append(queue.removeFirst());
        }

        if(sb.length() == 0){
            return "/";
        }else{
            return sb.toString();
        }
    }
}
