package second;

public class IntegerToRoman {
    public String intToRoman(int x) {
        int[] a = {1, 5, 10, 50, 100, 500, 1000};
        char[] b = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
        int[] pre = {0, 0, 0, 2, 2, 4, 4};
        StringBuffer sb = new StringBuffer();
        int p = 6;
        while(x > 0){
            if(x >= a[p]){
                sb.append(b[p]);
                x -= a[p];
            }else if(x >= a[p] - a[pre[p]]){
                sb.append(b[pre[p]]);
                sb.append(b[p]);
                x -= a[p] - a[pre[p]];
                p--;
            }else{
                p--;
            }
        }
        return sb.toString();
    }
}
