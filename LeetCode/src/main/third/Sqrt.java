package third;

public class Sqrt {
    public int mySqrt(int x) {
        if(x == 0 || x == 1) return x;

        return (int)binarySqrt(x, 1, x/2);
    }

    private long binarySqrt(int x, int start, int end){
        while(start <= end){
            // Need to use long to avoid integer overflow!
            long m = (start + end)/2;
            long r = m*m;
            long nextResult = (m+1) * (m+1);
            if(r == x){
                return m;
            }else if(r > x){
                end = (int)m - 1;
            }else if(nextResult <= x){
                // Avoid dead loop if start is not increased!
                start = (int)m + 1;
            }else{
                return m;
            }
        }

        return end;
    }
}
