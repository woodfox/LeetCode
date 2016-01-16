package second;

public class SingleNumberII {
    public int singleNumber(int[] a) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(a == null || a.length == 0){
            return -1;
        }
        
        int r = 0;
        int[] f = new int[32];
        for(int i=0;i<32;i++){
            for(int x : a){
                int y = (x>>i)&1;
                f[i] += y;
                f[i] = f[i]%3;
            }

            if(f[i] > 0){
                r = r | (1<<i);
            }
        }
        return r;
    }
}
