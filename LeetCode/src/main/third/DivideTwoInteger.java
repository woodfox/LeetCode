package third;

public class DivideTwoInteger {
    public int divide(int dividend, int divisor) {
        if(divisor == 0) return Integer.MAX_VALUE;

        boolean flag = true;
        if((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)){
            flag = false;
        }

        //Danger: Be careful of integer overflow when Math.abs(int.minValue)
        long absDividend = Math.abs((long)dividend);
        long absDivisor = Math.abs((long)divisor);

        long result = 0;
        long restDividend = absDividend;
        long restDivisor = absDivisor;
        long multiplier = 1;
        while(restDividend >= absDivisor) {
            if(restDividend >= restDivisor) {
                restDividend -= restDivisor;
                result += multiplier;
                multiplier += multiplier;
                restDivisor += restDivisor;
            }else{
                multiplier = 1;
                restDivisor = absDivisor;
            }
        }

        if(!flag) {
            result =  0 - result;
        }

        if(result > Integer.MAX_VALUE){
            result = Integer.MAX_VALUE;
        }else if(result < Integer.MIN_VALUE){
            result = Integer.MIN_VALUE;
        }

        return (int)result;
    }

    //-------------------------------------
    //Time: O(logn)
    public int divide_another(int a, int b) {
        long x = (long)a;
        long y = (long)b;
        long r;
        if(x<0 && y<0){
            r = calc(-x, -y);
        } else if(x<0){
            r = -1*calc(-x, y);
        } else if(y<0){
            r = -1*calc(x, -y);
        } else {
            r = calc(x, y);
        }
        if(r<Integer.MIN_VALUE || r>Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }
        return (int)r;
    }

    private long calc(long x, long y){
        if(x<y) return 0;
        else if(y==1) return x;

        long r = 1;
        long tmp = y;
        while(tmp + tmp <= x){
            tmp += tmp;
            r += r;
        }
        return r + calc(x-tmp, y);
    }
}
