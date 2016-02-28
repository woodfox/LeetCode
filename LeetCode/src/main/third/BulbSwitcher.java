package third;

/**
 * There are n bulbs that are initially off. You first turn on all the bulbs. Then, you turn off every second bulb. On the third round, you toggle every third bulb (turning on if it's off or turning off if it's on). For the nth round, you only toggle the last bulb. Find how many bulbs are on after n rounds.

 Example:

 Given n = 3.

 At first, the three bulbs are [off, off, off].
 After first round, the three bulbs are [on, on, on].
 After second round, the three bulbs are [on, off, on].
 After third round, the three bulbs are [on, off, off].

 So you should return 1, because there is only one bulb is on.
 */
public class BulbSwitcher {
    /**
     * If the bulb n is on, it requires odd numbers of toggle for numbers betwee (1, n).
     * And any number except x*x could be separated with even multipliers, such as 24 = 3*8 or 2*12 or 4*6
     * So only need to calculate how many x*x within n.
     *
     * Time: O(sqrt(n))
     */
    public int bulbSwitch(int n) {
        if (n == 0) return 0;

        int p=1;
        int total=0;
        while(p*p <= n) {
            total++;
            p++;
        }
        return total;
    }

    /**
     * Time Limit Exceed
     *
     * Time: O(n^2)
     */
    public int bulbSwitch_slow(int n) {
        if(n==0) return 0;

        int sum = 1;
        for(int i=n-1;i>1;i--){
            int c = 0;
            for(int j=i-1;j>1;j--){
                if(i%j==0) c++;
            }
            if(c%2 == 1) sum++;
        }
        return sum;
    }
}
