package third;

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
}
