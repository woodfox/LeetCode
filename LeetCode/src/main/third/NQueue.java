package third;

import java.util.ArrayList;
import java.util.List;

public class NQueue {
    public List<String[]> solveNQueens(int n) {
        List<String[]> result = new ArrayList<String[]>();
        if(n == 1) {
            result.add(new String[]{"Q"});
            return result;
        }
        else if(n <= 3) return result;

        List<Integer> sub = new ArrayList<Integer>();
        backtrack(n, sub, result);

        return result;
    }

    private void backtrack(int n, List<Integer> sub, List<String[]> result) {
        int row = sub.size();
        if(row >= n) {
            addToResult(sub, result);
        }else {
            for(int col=0;col<n;col++){
                if(isValid(sub, col)) {
                    sub.add(col);
                    backtrack(n, sub, result);
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

    private void addToResult(List<Integer> sub, List<String[]> result) {
        int n = sub.size();
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<n;i++) sb.append(".");

        String[] template = new String[n];
        for(int row=0;row<n;row++) {
            int col = sub.get(row);
            sb.setCharAt(col, 'Q');
            template[row] = sb.toString();
            sb.setCharAt(col, '.');
        }
        result.add(template);
    }
}
