package third;

import java.util.HashMap;
import java.util.Map;

/**
 * Convert a non-negative integer to its english words representation. Given input is guaranteed to be less than 231 - 1.

 For example,
 123 -> "One Hundred Twenty Three"
 12345 -> "Twelve Thousand Three Hundred Forty Five"
 1234567 -> "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
 Show Hint
 */
public class IntegerToEnglish {
    /**
     * Integer max number is about 2 billion.
     */
    public String numberToWords(int n) {
        if(n == 0) return "Zero";

        Map<Integer, String> map = getMap();
        StringBuffer sb = new StringBuffer();

        // Billion digits
        if(n >= 1000000000){
            int x = n/1000000000;
            sb.append(map.get(x) + " Billion ");
            n = n%1000000000;
        }

        // Million digits
        if(n >= 1000000){
            int x = n/1000000;
            sb.append(numberToWords(x) + " Million ");
            n = n%1000000;
        }

        // Thousand digits
        if(n >= 1000) {
            sb.append(numberToWords(n/1000) + " Thousand ");
            n = n%1000;
        }

        // Hundred digit
        if(n >= 100) {
            sb.append(map.get(n/100) + " Hundred ");
            n = n%100;
        }

        // Other digits
        if(map.containsKey(n)) {
            sb.append(map.get(n));
        } else {
            int x = n/10;
            if(x > 0) {
                sb.append(map.get(x*10) + " ");
                n = n%10;
            }

            if(n > 0) {
                sb.append(map.get(n));
            }
        }

        if(sb.charAt(sb.length()-1) == ' ') {
            sb.deleteCharAt(sb.length()-1);
        }
        return sb.toString();
    }

    private Map<Integer, String> getMap() {
        Map<Integer, String> m = new HashMap<Integer, String>();
        m.put(1, "One");
        m.put(2, "Two");
        m.put(3, "Three");
        m.put(4, "Four");
        m.put(5, "Five");
        m.put(6, "Six");
        m.put(7, "Seven");
        m.put(8, "Eight");
        m.put(9, "Nine");
        m.put(10, "Ten");
        m.put(11, "Eleven");
        m.put(12, "Twelve");
        m.put(13, "Thirteen");
        m.put(14, "Fourteen");
        m.put(15, "Fifteen");
        m.put(16, "Sixteen");
        m.put(17, "Seventeen");
        m.put(18, "Eighteen");
        m.put(19, "Nineteen");
        m.put(20, "Twenty");
        m.put(30, "Thirty");
        m.put(40, "Forty");
        m.put(50, "Fifty");
        m.put(60, "Sixty");
        m.put(70, "Seventy");
        m.put(80, "Eighty");
        m.put(90, "Ninety");
        return m;
    }
}
