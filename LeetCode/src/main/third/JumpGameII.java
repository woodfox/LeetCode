package third;

public class JumpGameII {
    public int jump(int[] a) {
        if(a == null || a.length <= 1) return 0;

        int start = 0;
        int end = 0;
        int count = 0;
        while(start <= end && end < a.length - 1){
            count++;
            int pos = end;
            for(int i=start;i<=end;i++){
                pos = Math.max(pos, i+a[i]);
            }
            start = end + 1;
            end = pos;
        }

        if(start > end) return Integer.MAX_VALUE;

        return count;
    }
}
