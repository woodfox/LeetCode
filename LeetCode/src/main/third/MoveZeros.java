package third;

public class MoveZeros {
    public void moveZeroes(int[] a) {
        int first = 0;
        for(int i=0;i<a.length;i++){
            if(a[i] != 0) {
                int tmp = a[i];
                a[i] = a[first];
                a[first] = tmp;
                first++;
            }
        }
    }
}
