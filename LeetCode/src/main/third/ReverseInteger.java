package third;

public class ReverseInteger {
    public int reverse(int x) {
        boolean negative = (x < 0);
        x = Math.abs(x);
        long y = 0;
        while(x > 0) {
            int digit = x % 10;
            x = x / 10;
            y = y *10 + digit;
        }

        if(y > Integer.MAX_VALUE) {
            return 0;
        }else if(negative){
            return (int) (-1 * y);
        }else{
            return (int) y;
        }
    }
}
