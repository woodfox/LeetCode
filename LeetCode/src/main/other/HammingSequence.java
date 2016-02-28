package other;

import java.util.ArrayList;
import java.util.List;

public class HammingSequence {
    public List<Integer> getSeq(int n) {
        List<Integer> result = new ArrayList<Integer>();
        result.add(1);

        // Current number after *2, *3, *5
        int x2 = 2;
        int x3 = 3;
        int x5 = 5;

        // Point to base number
        int p2 = 0;
        int p3 = 0;
        int p5 = 0;

        for(int i=2;i<=n;i++) {
            int min = Math.min(x2, x3);
            min = Math.min(min, x5);
            result.add(min);

            while(x2 <= min) {
                p2++;
                x2 = result.get(p2)*2;
            }

            while(x3 <= min) {
                p3++;
                x3 = result.get(p3)*3;
            }

            while(x5 <= min) {
                p5++;
                x5 = result.get(p5)*5;
            }
        }

        return result;
    }
}
