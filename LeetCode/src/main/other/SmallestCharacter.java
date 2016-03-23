package other;

/**
 * Given a sorted character array and a character, return the smallest character that is strictly larger than the search character.

 If no such character exists, return the smallest character in the array.

 For example:

 Input: [‘c’, ‘f’, ‘j’, ‘p’, ‘v’], ‘a’
 Output: ‘c’

 Input: [‘c’, ‘f’, ‘j’, ‘p’, ‘v’], ‘c’
 Output: ‘f’

 Input: [‘c’, ‘f’, ‘j’, ‘p’, ‘v’], ‘z’
 Output: ‘c’

 Input: [‘c’, ‘c’, ‘k’], ‘f’
 Output: ‘k’
 */
public class SmallestCharacter {
    char search(char[] a, char t) {
        int n = a.length;
        int l = 0;
        int r = n-1;
        while(l<=r){
            int m = (l+r)/2;
            if(a[m]>t) r = m-1;
            else l = m+1;
        }

        if(l>=n) return a[n-1];
        else return a[l];
    }
}
