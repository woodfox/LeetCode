package third;

import java.util.*;

public class GrayCode {
    /**
     *  000 -> 001 -> 011 -> 010 -> 110 -> 111 -> 101 -> 100
     */
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<Integer>();
        Set<Integer> set = new HashSet<Integer>();

        int num = 0;
        int total = 1 << n;
        while(result.size() < total){
            result.add(num);
            set.add(num);

            for(int i=0;i<n;i++){
                int next = num ^ (1 << i);
                if(!set.contains(next)) {
                    num = next;
                    break;
                }
            }
        }

        return result;
    }
}
