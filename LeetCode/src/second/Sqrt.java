package second;

public class Sqrt {
    public int sqrt(int x) {
        if(x == 0){
            return 0;
        }
        return binarySqrt(x, 0, x);
    }
    
    int binarySqrt(int x, int start, int end){
        if(start > end){
            return -1;
        }
        long m = (start + end)/2;
        long r = m*m;
        if(r == x){
            return (int)m;
        }else if(r > x){
            return binarySqrt(x, start, (int)m-1);
        }else{
            r = (m+1)*(m+1);
            if(r > x){
                return (int)m;
            }
            return binarySqrt(x, (int)m+1, end);
        }
    }
}
