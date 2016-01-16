package second;

import java.util.Arrays;

public class NextPermutation {
    public void nextPermutation(int[] a) {
        int n = a.length;
        if(n <= 1){
            return;
        }
        
        for(int i=n-2;i>=0;i--){
            int min = -1;
            for(int j=i+1;j<n;j++){
                if(a[j] > a[i]){
                    if(min == -1 || a[min] > a[j]){
                        min = j;
                    }
                }
            }
            if(min != -1){
                swap(a, i, min);
                Arrays.sort(a, i+1, n);
                return;
            }
        }
        Arrays.sort(a);
    }
    
    void swap(int[] a, int i, int j){
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
