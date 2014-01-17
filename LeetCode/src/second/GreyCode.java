package second;

import java.util.ArrayList;
import java.util.HashSet;

public class GreyCode {
    public ArrayList<Integer> grayCode(int n) {
        ArrayList<Integer> r = new ArrayList<Integer>();
        if(n == 0){
        	r.add(0);
            return r;
        }
        
        HashSet<Integer> set = new HashSet<Integer>();
        int x = 0;
        while(true){
            r.add(x);
            set.add(x);
            int i;
            for(i = 0;i<n;i++){
                int y = x^(1<<i);
                if(!set.contains(y)){
                    x = y;
                    break;
                }
            }
            if(i >= n){
                break;
            }
        }
        return r;
    }
}
