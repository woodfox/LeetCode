package third;

/**
 * Given two strings S and T, determine if they are both one edit distance apart.
 * Hint: 1. If | n – m |is greater than 1, we know immediately both are not one-edit distance apart.
 * 2. It might help if you consider these cases separately,m == nandm ≠ n.
 * 3. Assume that m is always ≤ n, which greatly simplifies the conditional statements.
 *   Ifm > n, we could just simply swap S and T.
 * 4. Ifm == n, it becomes finding if there is exactly one modified operation.
 *    Ifm ≠ n` you do not have to consider the delete operation. Just consider the insert operation in T.
 */
public class OneEditDistance {
    public boolean isOneEditDistance(String s, String t) {
        if(s == null || t == null) {
            return false;
        }

        int m = s.length();
        int n = t.length();
        if(Math.abs(m-n) > 1) {
            return false;
        } else if(m > n) {
            return isOneEditDistance(t, s);
        }

        int i=0;
        int j=0;
        int diff = 0;
        while(i < m && j < n) {
            if(s.charAt(i) != t.charAt(j)) {
                diff++;
                if(m == n) {
                    // Allow one modification if length is equal
                    i++;
                    j++;
                } else {
                    // Allow one delete in longer string (no modification)
                    j++;
                }
            } else {
                i++;
                j++;
            }

            if(diff > 1) {
                break;
            }
        }

        return diff <= 1;
    }
}
