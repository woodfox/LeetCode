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
}
