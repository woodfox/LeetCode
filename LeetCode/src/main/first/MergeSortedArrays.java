package first;

public class MergeSortedArrays {
    public void merge(int a[], int m, int b[], int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int i = m-1;
        int j = n-1;
        while(i >= 0 && j >= 0){
            if(a[i] > b[j]){
                a[i+j+1] = a[i];
                i--;
            }else{
                a[i+j+1] = b[j];
                j--;
            }
        }
        
        for(int k=j;k>=0;k--){
            a[k] = b[k];
        }
    }
}
