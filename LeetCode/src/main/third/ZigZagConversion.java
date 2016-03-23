package third;

import java.util.ArrayList;
import java.util.List;

public class ZigZagConversion {
    /**
     * Zigzag orders:
     * -----------------------
     *  0   8
     *  1 7 9  15
     *  2 6 10 14
     *  3 5 11 13
     *  4   12
     * -----------------------
     * When nRows = 2, it's actually like below:
     * -----------------------
     * 0 2 4 6
     * 1 3 5 7
     */
    public String convert(String s, int nRows) {
        if(s == null || s.length() <= 1 || nRows == 1) return s;

        StringBuffer sb = new StringBuffer();
        int n = s.length();
        for(int i=0;i<nRows;i++){
            int j = 0;
            int pos = i;
            while(pos < n){
                if(!shouldSkip(i, j, nRows)){
                    sb.append(s.charAt(pos));
                }
                j++;
                if(j%2 == 0){
                    pos += 2*i;
                }else {
                    pos += 2*(nRows - i - 1);
                }
            }
        }
        return sb.toString();
    }

    private boolean shouldSkip(int row, int col, int nRows) {
        return (row == 0 || row == nRows-1)  && col%2 == 1;
    }

    /**
     * Another way to convert to zigzag by creating vertical strings first, then going throw every row.
     */
    public String convert_withList(String s, int lines) {
        if(lines == 1) return s;

        List<String> l = new ArrayList();
        int length = s.length();
        int i=0;
        int k=0;
        while(i<length){
            if(k%2==0){
                int end = Math.min(length, i+lines);
                l.add(s.substring(i, end));
                i+=lines;
            } else {
                int end = Math.min(length, i+lines-2);
                // For even column, it's in reverse order (bottom to up)
                StringBuffer sb = new StringBuffer(" " + s.substring(i, end) + " ");
                // Need to append space at last to be same length so that it's correct after reverse
                for(int j=end-i+2;j<lines;j++) sb.append(" ");

                l.add(sb.reverse().toString());
                i+=lines-2;
            }
            k++;
        }

        StringBuffer sb = new StringBuffer();
        for(int j=0;j<lines;j++){
            for(String t : l){
                if(j>=t.length() || t.charAt(j) == ' ') continue;
                sb.append(t.charAt(j));
            }
        }
        return sb.toString();
    }
}
