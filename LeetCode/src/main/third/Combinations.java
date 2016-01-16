package third;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        backtrace(1, n, list, result, k);

        return result;
    }

    private void backtrace(int start, int n, List<Integer> list, List<List<Integer>> result, int k) {
        if(list.size() >= k) {
            result.add(new ArrayList(list));
        }else{
            for(int i=start;i<=n;i++){
                list.add(i);
                backtrace(i+1, n, list, result, k);
                list.remove(list.size()-1);
            }
        }
    }
}
