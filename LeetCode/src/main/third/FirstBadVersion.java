package third;

public class FirstBadVersion {
    public int firstBadVersion(int n) {
        int l = 1;
        int r = n;
        while(l < r) {
            int m = l + (r-l)/2;
            if(isBadVersion(m)){
                r = m;
            } else {
                l = m+1;
            }
        }
        return l;
    }

    private boolean isBadVersion(int n) {
        return false;
    }
}
