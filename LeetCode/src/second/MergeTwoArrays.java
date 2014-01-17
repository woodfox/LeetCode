package second;

public class MergeTwoArrays {
    public void merge(int[] a, int m, int[] b, int n) {
        int i = m-1;
        int j = n-1;
        int k = m+n-1;
        if(n == 0){
            return;
        }
        
        while(i>=0 || j>=0){
            int x = Integer.MIN_VALUE;
            if(i >= 0){
                x = a[i];
            }
            
            int y = Integer.MIN_VALUE;
            if(j >= 0){
                y = b[j];
            }
            
            if(x >= y){
                a[k--] = a[i--];
            }else{
                a[k--] = b[j--];
            }
        }
    }
}
