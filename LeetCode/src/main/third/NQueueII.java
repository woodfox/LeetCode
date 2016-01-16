package third;

import java.util.ArrayList;
import java.util.List;

public class NQueueII {
    int total = 0;

    public int totalNQueens(int n) {
        if(n == 1) {
            return 1;
        }
        else if(n <= 3) return 0;

        List<Integer> sub = new ArrayList<Integer>();
        backtrack(n, sub);
        return total;
    }

    private void backtrack(int n, List<Integer> sub) {
        int row = sub.size();
        if(row >= n) {
            total++;
        }else {
            for(int col=0;col<n;col++){
                if(isValid(sub, col)) {
                    sub.add(col);
                    backtrack(n, sub);
                    sub.remove(sub.size() - 1);
                }
            }
        }
    }

    private boolean isValid(List<Integer> sub, int nextPos) {
        int nextRow = sub.size();
        // Check if this column has already have queue
        for(int col : sub) {
            if(nextPos == col) return false;
        }

        // Check the other line
        for(int row=0;row<nextRow;row++){
            int col = sub.get(row);
            if(Math.abs(nextPos - col) == Math.abs(nextRow - row)) return false;
        }

        return true;
    }
}
