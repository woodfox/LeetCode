package second;

public class ReverseInteger {
    public int reverse(int x) {
        int flag = 1;
        if(x < 0){
            flag = -1;
            x = x*-1;
        }
        
        int r = 0;
        while(x > 0){
            int y = x%10;
            r = r*10 + y;
            x = x/10;
        }
        return r*flag;
    }
}
