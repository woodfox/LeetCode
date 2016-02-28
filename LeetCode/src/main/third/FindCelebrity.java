package third;


public class FindCelebrity {
    int findCelebrity(int n) {
        int l =1;
        int r = n;
        while(l < r) {
            if(knows(l, r)) {
                // l can not be celebrity
                l++;
            } else {
                // R can not be celebrity
                r--;
            }
        }

        for(int i=1;i<=n;i++){
            if(i!= r && (!knows(i, r) || knows(r, i))) return -1;
        }
        return r;
    }

    private boolean knows(int i, int j) {
        return true;
    }
}
