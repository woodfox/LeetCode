package third;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        if(digits == null || digits.length == 0) return digits;

        int n = digits.length;
        int addOn = 1;
        for(int i=n-1;i>=0;i--){
            int sum = digits[i] + addOn;
            digits[i] = sum%10;
            addOn = sum/10;
        }
        if(addOn == 0) {
            return digits;
        }else{
            int[] result = new int[n+1];
            result[0] = 1;
            for(int i=1;i<=n;i++) result[i] = digits[i-1];
            return result;
        }
    }
}
