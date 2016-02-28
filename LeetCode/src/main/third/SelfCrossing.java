package third;

public class SelfCrossing {
    /**
     * If it's decreasing, it should be within the limit;
     * If it's increasing but change to decreasing, then the new limit should be x3-x1 (if t >= x2-x0) or x3
     *             x1
     *          ________
     *          |       |   |
     *        x2|    x0 |   |(t)
     *          |___________|
     *             x3
     */
    public boolean isSelfCrossing(int[] a) {
        int n = a.length;
        if(n<4) return false;
        int x0 = 0;
        int x1 = a[0];
        int x2 = a[1];
        int x3 = a[2];
        boolean increase = (x3>x1);
        for(int i=3;i<n;i++){
            int t = a[i];
            if(!increase && t>=x2) {
                // Should decrease but the length is exceeding limit
                return true;
            } else  if(increase && t<=x2) {
                increase = false;
                // It may change from increase to decrease
                // In this case the next limit would be different according to t
                if(t>=x2-x0) x3 -= x1;
            }
            x0 = x1;
            x1 = x2;
            x2 = x3;
            x3 = t;
        }
        return false;
    }
}
