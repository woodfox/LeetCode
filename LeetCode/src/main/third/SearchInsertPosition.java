package third;

public class SearchInsertPosition {
    public int searchInsert(int[] a, int target) {
        return binarySearch(a, 0, a.length-1, target);
    }

    private int binarySearch(int[] a, int start, int end, int t){
        while(start <= end){
            int middle = (start+end)/2;
            if(a[middle] == t){
                return middle;
            }else if(a[middle] < t){
                start = middle+1;
            }else{
                end = middle-1;
            }
        }

        //How to prove the correctness that next insertion position is end+1?
        return end+1;
    }
}
