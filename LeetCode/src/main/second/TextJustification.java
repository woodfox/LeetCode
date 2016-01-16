package second;

import java.util.ArrayList;
import java.util.LinkedList;

public class TextJustification {
    public ArrayList<String> fullJustify(String[] a, int l) {
        ArrayList<String> r = new ArrayList<String>();
        if(a == null || a.length == 0){
            return r;
        }
        
        LinkedList<String> q = new LinkedList<String>();
        int n = a.length;
        int p = 0;
        while(p < n){
            q.clear();
            q.add(a[p]);
            int count = a[p].length();
            p++;
            while(p < n){
                String s = a[p];
                if(count + s.length() + 1 <= l){
                    q.add(s);
                    count += s.length() + 1;
                    p++;
                }else{
                    break;
                }
            }
            if(p >= n){
                r.add(createLastLine(q, l));
            }else{
                r.add(createLine(q, count, l));
            }
        }
        
        return r;
    }
    
    String createLine(LinkedList<String> q, int count, int l){
        int n = q.size();
        int spaces = l - count;
        int left = 0;
        int extra = 0;
        if(n > 1){
            extra = spaces/(n-1);
            left = spaces%(n-1);
        }else{
            extra = spaces;
            left = 0;
        }
        
        StringBuffer sb = new StringBuffer();
        sb.append(q.get(0));
        if(n <= 1){
            for(int j=0;j<extra;j++){
                sb.append(" ");
            }
        }
        
        for(int i=1;i<n;i++){
            sb.append(" ");
            for(int j=0;j<extra;j++){
                sb.append(" ");
            }
            
            if(left > 0){
                sb.append(" ");
                left--;
            }
            sb.append(q.get(i));
        }
        return sb.toString();
    }
    
    String createLastLine(LinkedList<String> q, int l){
        StringBuffer sb = new StringBuffer();
        sb.append(q.get(0));
        int count = q.get(0).length();
        for(int i=1;i<q.size();i++){
            String s = q.get(i);
            sb.append(" " + s);
            count += s.length() + 1;
        }
        
        for(int i=count+1;i<=l;i++){
            sb.append(" ");
        }
        return sb.toString();
    }
}
