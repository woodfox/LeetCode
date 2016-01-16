package second;

public class AddBinary {
    public String addBinary(String a, String b) {
        if(a == null || b == null){
            return null;
        }
        StringBuffer sb = new StringBuffer();
        int m = a.length();
        int n = b.length();
        int i = m-1;
        int j = n-1;
        int added = 0;
        while(i >=0 || j >= 0){
            int x = 0;
            if(i >= 0){
                x = a.charAt(i) -'0';
            }
            int y = 0;
            if(j >= 0){
                y = b.charAt(j) - '0';
            }
            int r= x + y + added;
            sb.append(r%2);
            added = r/2;
            i--;
            j--;
        }
        if(added > 0){
            sb.append(added);
        }
        sb.reverse();
        return sb.toString();
    }
}
