package third;

import java.util.ArrayList;
import java.util.List;

/**
 * Be careful when numRows is 0!
 */
public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(numRows == 0) {
            return result;
        }

        List<Integer> first = new ArrayList<Integer>();
        first.add(1);
        result.add(first);

        for(int i=2;i<=numRows;i++) {
            List<Integer> prev = result.get(i-2);

            List<Integer> row = new ArrayList<Integer>();
            row.add(1);

            for(int j=2;j<i;j++) {
                int value = prev.get(j-2) + prev.get(j-1);
                row.add(value);
            }

            row.add(1);
            result.add(row);
        }

        return result;
    }
}
