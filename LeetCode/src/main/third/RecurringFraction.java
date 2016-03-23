package third;

import java.util.*;

/**
 *
 If the fractional part is repeating, enclose the repeating part in parentheses.

 For example,

 Given numerator = 1, denominator = 2, return "0.5".
 Given numerator = 2, denominator = 1, return "2".
 Given numerator = 2, denominator = 3, return "0.(6)".
 */
public class RecurringFraction {
    /**
     * Integer part:  a/b
     * Decimal part:
     * if x already in hashMap, fetch the decimal string;
     * else:
     *   if x*10 < b, append '0', and calculate x*10/b, and add x to hashMap
     *   if x*10 >= b, append (x10/b), and calculate (x%b), and add x to hashMap
     *
     * Be careful:
     * 1. if a or b is negative!!
     * 2. use long to avoid overflow when a/b is Integer.MAX_VALUE or MIN_VALUE
     */
    public String fractionToDecimal(int a, int b) {
        // Handle negative cases!
        if (a < 0 || b < 0) {
            long x = (long)a;
            long y = (long)b;
            boolean negative = x * y < 0;
            return calculate(Math.abs(x), Math.abs(y), negative);
        } else {
            return calculate(Math.abs(a), Math.abs(b), false);
        }
    }

    private String calculate(long a, long b, boolean negative) {
        StringBuffer sb = new StringBuffer();
        if(negative) {
            sb.append("-");
        }
        sb.append(a/b);
        long remain = a%b;

        if(remain == 0) {
            return sb.toString();
        }

        Map<Long, Long> map = new HashMap<Long, Long>();
        List<Long> list = new ArrayList<Long>();
        long end = calcFraction(remain, b, list, map);

        sb.append(".");
        for(long x : list) {
            if(x == end) {
                sb.append("(");
            }
            sb.append(map.get(x));
        }
        if(end > 0) {
            sb.append(")");
        }
        return sb.toString();
    }

    private long calcFraction(long remain, long b, List<Long> list, Map<Long, Long> map) {
        if(remain == 0){
            // No remaining anymore, so no recurring of fraction
            return -1;
        }else if(map.containsKey(remain)) {
            return remain;
        }

        long a = remain * 10;
        list.add(remain);
        map.put(remain, a/b);
        return calcFraction(a % b, b, list, map);
    }

    /**
     * Use LinkedHashMap to maintain the decimal points and find the loop.
     */
    public String fractionToDecimal_linkedHashMap(int a, int b) {
        if(a < 0||b<0) {
            String flag = "";
            if(((long)a)*b < 0) flag = "-";
            return flag + toDecimal(Math.abs((long)a), Math.abs((long)b));
        }

        return toDecimal(a, b);
    }

    private String toDecimal(long a, long b) {
        StringBuffer sb = new StringBuffer();
        if(a>=b){
            sb.append(a/b);
            a = a%b;
        }else {
            sb.append(0);
        }
        if(a ==0) return sb.toString();

        a *= 10;
        long dup = -1;
        LinkedHashMap<Long,Long> map = new LinkedHashMap();
        while(a > 0) {
            if(map.containsKey(a)) {
                dup = a;
                break;
            } else if(a<b){
                map.put(a, 0L);
            } else {
                map.put(a, a/b);
                a = a%b;
            }
            a *= 10;
        }

        sb.append(".");
        for(long k : map.keySet()){
            if(dup == k) sb.append("(");
            sb.append(map.get(k));
        }
        if(dup > 0) sb.append(")");

        return sb.toString();
    }
}
