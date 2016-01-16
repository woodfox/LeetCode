package second;

public class Pow {
    public double pow(double x, int n) {
        if(x == 0){
            return 0;
        }
        else if(x == 1){
            return 1;
        }
        else if(x == -1){
            if(n%2 == 0){
                return 1;
            }else{
                return -1;
            }
        }
        else if(n == 0){
            return 1;
        }else if(n == 1){
            return x;
        }else if(n < 0){
            return 1/pow(x, -1*n);
        }else{
            double r = pow(x, n/2);
            r = r*r;
            if(n%2 != 0){
                r = r*x;
            }
            return r;
        }
    }
}
