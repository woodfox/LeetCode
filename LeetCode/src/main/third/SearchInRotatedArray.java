package third;

// O(lgn)
public class SearchInRotatedArray {
    public int search(int[] a, int target) {
        if(a == null || a.length == 0) return -1;

        return binarySearch(a, 0, a.length-1, target);
    }

    private int binarySearch(int[] a, int start, int end, int target){
        if(start > end) return -1;

        int middle = (start + end)/2;
        if(a[middle] == target){
            return middle;
        }else if(a[middle] < target){
            if(a[end] < a[middle] || target <= a[end]){
                return binarySearch(a, middle+1, end, target);
            }else{
                return binarySearch(a, start, middle-1, target);
            }
        }else{
            if(a[start] > a[middle] || target >= a[start]){
                return binarySearch(a, start, middle-1, target);
            }else{
                return binarySearch(a, middle+1, end, target);
            }
        }
    }
}
