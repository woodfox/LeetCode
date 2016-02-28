package third;

public class FlipGameII {
    /**
     * Try all possible solution to win.
     *
     * Time: f(n) = f(0) + f(n-2) + f(1) + f(n-3) + ...
     *            = 2(f(1)+f(2)+f(3)+...+f(-2))
     *            = O(n!)
     */
    boolean canWin(String s) {
        int i = 0;
        while(i < s.length()) {
            int p = s.indexOf("++", i);

            // Be careful when p is -1!
            if(p == -1) break;

            if(!canWin(s.substring(0, p) + "-" + s.substring(p+2))){
                return true;
            }

            i = p+1;
        }

        return false;
    }

    boolean canWin_simple(String s) {
        for(int i=-1;(i=s.indexOf("++",i+1))>-1;) {
            if(!canWin(s.substring(0,i) + "-" + s.substring(i+2))) {
                return true;
            }
        }

        return false;
    }
}
