package third;

public class JumpGame {
    public boolean canJump(int[] a) {
        if(a == null || a.length == 0) return false;

        int start = 0;
        int end = 0;
        while(start <= end && end < a.length-1) {
            int next = end;
            for(int pos=start;pos<=end;pos++){
                next = Math.max(next, pos + a[pos]);
            }
            start = end+1;
            end = next;
        }

        return (end >= a.length-1);
    }
}
