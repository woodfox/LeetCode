package third;

// O(lgn)
public class SearchInRotatedArrayII {
    public boolean search(int[] a, int target) {
        if(a == null || a.length == 0) return false;

        return binarySearch(a, 0, a.length-1, target);
    }

    private boolean binarySearch(int[] a, int start, int end, int target){
        if(start > end) return false;

        int middle = (start + end)/2;
        if(a[middle] == target){
            return true;
        }else if(a[middle] < target){
            // Move the end if it's same with middle, so that we know if it has increasing numbers
            while(middle < end && a[end] == a[middle]){
                end--;
            }
            if(a[end] < a[middle] || target <= a[end]){
                return binarySearch(a, middle+1, end, target);
            }else{
                return binarySearch(a, start, middle-1, target);
            }
        }else{
            // Move the start if it's same with middle, so that we know if it has increasing numbers
            while(start < middle && a[start] == a[middle]){
                start++;
            }
            if(a[start] > a[middle] || target >= a[start]){
                return binarySearch(a, start, middle-1, target);
            }else{
                return binarySearch(a, middle+1, end, target);
            }
        }
    }
}
