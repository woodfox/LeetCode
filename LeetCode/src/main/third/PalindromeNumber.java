package third;

public class PalindromeNumber {
    /**
     * Be careful when exceeding Integer.MAX_VALUE
     * And handle the special case 10000021
     */
    public boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }

        long y = x;
        long primes = 1;
        while(primes * 10 <= y) {
            primes *= 10;
        }
        while(primes > 1){
            long first = y / primes;
            long last = y % 10;
            if(first != last){
                return false;
            }
            y = y % primes;
            y = y/10;
            primes = primes / 100;
        }
        return true;
    }
}
