package other;

import java.util.ArrayList;
import java.util.List;

class PrimeNumbers {
    // generate all prime numbers within n
    List<Integer> primeByFilter(int n) {
        List<Integer> result = new ArrayList<Integer>();
        if(n < 1) {
            return result;
        } else if(n == 1) {
            result.add(1);
            return result;
        }

        // precondition: n>=2

        // Invariant: For prime i, i*j is marked as non-prim (j>=2 && j*i<=n)
        boolean[] a = new boolean[n+1];
        for(int i=0;i<=n;i++) {
            a[i] = true;
        }

        for(int i=2;i<=n;i++) {
            if(!a[i]) {
                continue;
            }

            for(int j=2;i*j<=n;j++) {
                a[i*j] = false;
            }
        }

        //Post-condition: all prime are true in array, and non-prime are false

        for(int i=1;i<=n;i++) {
            if(a[i]) {
                result.add(i);
            }
        }
        return result;
    }
}
