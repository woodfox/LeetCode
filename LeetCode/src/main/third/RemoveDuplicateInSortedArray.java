package third;

public class RemoveDuplicateInSortedArray {
    public int removeDuplicates(int[] a) {
        if(a == null || a.length == 0) return 0;

        int pos = 0;
        for(int i=0;i<a.length;i++){
            if(i > 0 && a[i] == a[i-1]) continue;

            a[pos] = a[i];
            pos++;
        }
        return pos;
    }
}
