package third;

public class AddBinary {
    public String addBinary(String a, String b) {
        if(a == null || b == null) return null;

        int m = a.length();
        int n = b.length();
        int addOn = 0;
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<Math.max(m, n);i++){
            int x = getNumber(a, m-1-i);
            int y = getNumber(b, n-1-i);
            int sum = x + y + addOn;
            sb.append(sum % 2);
            addOn = sum/2;
        }
        if(addOn > 0) sb.append(addOn);

        return sb.reverse().toString();
    }

    private int getNumber(String s, int pos){
        if(pos >= 0) return s.charAt(pos) - '0';
        else return 0;
    }
}
