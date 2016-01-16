package first;

public class ZigzagConversion {
    public String convert(String s, int row) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	if(row <= 1) return s;
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<row;i++){
            int j = i;
            int col = 0;
            while(j < s.length()){
                sb.append(s.charAt(j));
                col++;
                if(i == 0 || i == row-1){
                    j += 2*row - 2;
                }else if(col%2 == 1){
                    j += 2*(row-i) -2;
                }else{
                    j += 2*i;
                }
            }
        }
        return sb.toString();
    }
}
