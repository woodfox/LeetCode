package second;

public class DivideInteger {
    public int divide(int a, int b) {
        if(b == 0){
            return Integer.MIN_VALUE;
        }
        
        boolean flag = true;
        if((a<0&&b>0) || (a>0&&b<0)){
            flag = false;
        }
        
        long c = a;
        long d = b;
        if(c<0){
            c = abs(c);
        }
        if(d<0){
            d = abs(d);
        }
        
        if(c<d){
            return 0;
        }else{
            long x = d;
            int k = 1;
            while(x + x <= c){
                x = x + x;
                k = k<<1;
            }
            int r = k + divide((int)(c-x), (int)d);
            return setFlag(r, flag);
        }
    }
    
    long abs(long x){
        return ~x + 1;
    }
    
    int setFlag(int x, boolean flag){
        if(flag){
            return x;
        }else{
            return ~x + 1;
        }
    }
    
    public static void main(String[] args){
    	DivideInteger d = new DivideInteger();
    	System.out.println(d.divide(-1010369383, -2147483648));
    }
}
