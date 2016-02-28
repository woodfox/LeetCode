package third;

/**
 * Description:

 Count the number of prime numbers less than a non-negative number, n.
 */
public class CountPrimes {
    public int countPrimes(int n) {
        if(n <= 2) {
            return 0;
        }
        int[] a = new int[n];
        for(int i=2;i<n;i++) {
            if(a[i] == 0) {
                for(int j=2;i*j<n;j++) {
                    a[i*j] = -1;
                }
            }
        }

        int count = 0;
        for(int i=2;i<n;i++) {
            if(a[i] == 0) {
                count++;
            }
        }
        return count;
    }
}
