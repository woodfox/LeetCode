package third;

public class Pow {
    public double pow(double x, int n) {
        if(n > 0) return power(x, n);
        else return 1/power(x, -1 * n);
    }

    private double power(double x, int n){
        if(n == 0) return 1;
        else if(n == 1) return x;
        else if(x == 0) return 0;
        else if(x == 1 || x == -1) return power(x, n%2);

        double r = power(x, n/2);
        return r * r * power(x, n%2);
    }
}
