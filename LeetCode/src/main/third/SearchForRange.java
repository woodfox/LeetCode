package third;

public class SearchForRange {
    // Or use binarySearch and use loop to find first and last element
    public int[] searchRange(int[] a, int target) {
        int[] result = new int[2];
        result[0] = findFirst(a, 0, a.length-1, target);
        result[1] = findLast(a, 0, a.length-1, target);
        return result;
    }

    private int findFirst(int[] a, int start, int end, int t) {
        if(start > end) {
            return -1;
        }else if(end - start <= 1){
            if(a[start] == t) return start;
            else if(a[end] == t) return end;
            else return -1;
        }

        int middle = (start + end)/2;
        if(a[middle] == t){
            return findFirst(a, start, middle, t);
        }else if(a[middle] < t){
            return findFirst(a, middle+1, end, t);
        }else{
            return findFirst(a, start, middle-1, t);
        }
    }

    private int findLast(int[] a, int start, int end, int t) {
        if(start > end) {
            return -1;
        }else if(end - start <= 1){
            // Avoid dead loop when two elements in array
            if(a[end] == t) return end;
            else if(a[start] == t) return start;
            else return -1;
        }

        int middle = (start + end)/2;
        if(a[middle] == t){
            return findLast(a, middle, end, t);
        }else if(a[middle] < t){
            return findLast(a, middle + 1, end, t);
        }else{
            return findLast(a, start, middle - 1, t);
        }
    }
}
