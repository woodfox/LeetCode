package third;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalTriangleII {
    public List<Integer> getRow(int rowIndex) {
        if (rowIndex == 0) {
            List<Integer> result = new ArrayList<Integer>();
            result.add(1);
            return result;
        }

        // Initialize the values in arrays
        Integer[] row = new Integer[rowIndex+1];
        Integer[] next = new Integer[rowIndex+1];
        for (int i = 0; i <= rowIndex; i++) {
            row[i] = 1;
            next[i] = 1;
        }

        for (int i = 2; i <= rowIndex; i++) {
            for(int j=1;j<i;j++) {
                next[j] = row[j-1] + row[j];
            }

            // Swap reference
            Integer[] tmp = row;
            row = next;
            next = tmp;
        }

        return Arrays.asList(row);
    }
}
