package third;

public class RemoveElementInArray {
    public int removeElement(int[] a, int elem) {
        if(a == null || a.length == 0) return 0;

        int pos = 0;
        for(int i=0;i<a.length;i++){
            if(a[i] != elem) {
                a[pos++] = a[i];
            }
        }
        return pos;
    }
}
