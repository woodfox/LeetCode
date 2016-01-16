package third;

import java.util.ArrayList;
import java.util.List;

public class PermutationSeq {
    public String getPermutation(int n, int k) {
        List<Integer> list = new ArrayList<Integer>();
        for(int i=1;i<=n;i++) list.add(i);

        StringBuffer result = new StringBuffer();
        //Use k-1 as position starting from 0
        getKthPermutation(list, k-1, result);

        return result.toString();
    }

    private void getKthPermutation(List<Integer> list, int k, StringBuffer result){
        int n = list.size();
        //Danger: exit if there is no integer in list!!
        if(n == 0) return;

        int total = (int)getTotal(n-1);
        int pos = k/total;
        result.append(list.get(pos));
        //Delete the used integer
        list.remove(pos);
        getKthPermutation(list, (int)(k%total), result);
    }

    private long getTotal(int n) {
        long result = 1;
        for(int i=1;i<=n;i++) result *= i;
        return result;
    }
}
