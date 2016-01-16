package third;

public class IntegerToRoman {
    public String intToRoman(int num) {
        char[] chars = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
        int[] values = {1, 5, 10, 50, 100, 500, 1000};
        int[] pre = {-1, 0, 0, 2, 2, 4, 4};
        StringBuffer result = new StringBuffer();

        int pos = values.length-1;
        while(num > 0){
            if(num >= values[pos]){
                result.append(chars[pos]);
                num -= values[pos];
            }else if(pre[pos] != -1 && num >= values[pos] - values[pre[pos]]){
                // Only 1, 10, 100, 1000 can reduce with previous number, such as IX
                result.append(chars[pre[pos]]);
                result.append(chars[pos]);
                num -= values[pos] - values[pre[pos]];
                pos--;
            }else {
                pos--;
            }
        }

        return result.toString();
    }
}
