package second;

public class SortColor {
    public void sortColors(int[] a) {
        if(a.length == 0){
            return;
        }
        
        quickSort(a, 0, a.length-1);
    }
    
    void quickSort(int[] a, int start, int end){
        if(start < end){
            int p = partition(a, start, end);
            quickSort(a, start, p-1);
            quickSort(a, p+1, end);
        }
    }
    
    int partition(int[] a, int start, int end){
        int v = a[end];
        int firstHigh = start;
        for(int i=start;i<end;i++){
            if(a[i] < v){
                swap(a, i, firstHigh++);
            }
        }
        swap(a, firstHigh, end);
        return firstHigh;
    }
    
    void swap(int[] a, int i, int j){
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
