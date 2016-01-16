package second;

public class ZigzagConversation {
    public String convert(String s, int n) {
        if(n <= 1){
    		return s;
    	}
    	
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<n;i++){
            int j= i;
            int k = 0;
            while(j < s.length()){
                sb.append(s.charAt(j));
                if(i == 0 || i == n-1){
                    j += 2*n -2;
                }else if(k%2 == 0){
                    j += 2*(n-i) - 2;
                }else{
                    j += 2*i;
                }
                k++;
            }
        }
        return sb.toString();
    }
}
