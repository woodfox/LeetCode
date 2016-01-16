package second;

import java.util.LinkedList;

public class LongestValidParenthesis {
    public int longestValidParentheses(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        
        LinkedList<Integer> q = new LinkedList<Integer>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c == '('){
                add(q, -1);
            }else {
                add(q, -2);
            }
        }
        
        int max = 0;
        for(int x : q){
            max = Math.max(max, x);
        }
        return max;
    }
    
    void add(LinkedList<Integer> q, int c){
        if(c == -1){
            q.add(c);
        }else{
            int prev = 0;
            int n = q.size();
            if(n > 0){
                prev = q.removeLast();
            }
            if(c == -2){
                if(prev == -1){
                    add(q, 2);
                }else if(prev > 0 && !q.isEmpty() && q.peekLast() == -1){
                    q.removeLast();
                    add(q, prev+2);
                }else{
                    if(prev != 0){
                        q.add(prev);
                    }
                    q.add(c);
                }
            }else {
                if(prev > 0){
                    add(q, prev+c);
                }else{
                    if(prev != 0){
                        q.add(prev);
                    }
                    q.add(c);
                }
            }
        }
    }
    
	//TLE exception!!
    public int longestValidParentheses2(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        
        int n = s.length();
        int[] a = new int[n];
        for(int i=0;i<n;i++){
            char c = s.charAt(i);
            if(c == '('){
                a[i] = -1;
            }else{
                a[i] = -2;
            }
        }
        
        while(true){
            int i = 0;
            int left = -1;
            int right = -1;
            while(i<n && right == -1){
                if(a[i] == -1){
                    left = i;
                }else if(a[i] == -2 && left != -1){
                    right = i;
                }
                i++;
            }
            if(right == -1){
                break;
            }
            int count = 0;
            for(int j = left+1;j<right;j++){
                count += a[j];
                a[j] = 0;
            }
            a[left] = 0;
            a[right] = count+2;
        }
        
        int max = 0;
        for(int i=0;i<n;i++){
            max = Math.max(max, a[i]);
        }
        return max;
    }
}
