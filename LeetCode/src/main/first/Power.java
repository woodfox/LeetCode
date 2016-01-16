package first;

public class Power {
    /*
     * Be careful when x = 1, -1 or n < 0!!!
     */
    public double pow(double x, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (x == 1) {
            return 1;
        }
        else if (x == -1) {
            if (n % 2 == 0) {
                return 1;
            }
            else {
                return -1;
            }
        }
        
        if (n < 0) {
            return 1 / pow(x, Math.abs(n));
        }
        else if (n == 0) {
            return 1;
        }
        else if (n == 1) {
            return x;
        }
        else {
            double f = pow(x, n / 2);
            if (n % 2 == 0) {
                return f * f;
            }
            else {
                return f * f * x;
            }
        }
    }
    
}
