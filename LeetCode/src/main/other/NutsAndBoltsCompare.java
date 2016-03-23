package other;

/**
 * Given a set of n nuts of different sizes and n bolts of different sizes. There is a one-one mapping between nuts and bolts. Comparison of a nut to another nut or a bolt to another bolt is not allowed. It means nut can only be compared with bolt and bolt can only be compared with nut to see which one is bigger/smaller.

 We will give you a compare function to compare nut with bolt.

 Given nuts = ['ab','bc','dd','gg'], bolts = ['AB','GG', 'DD', 'BC'].

 Your code should find the matching bolts and nuts.

 one of the possible return:

 nuts = ['ab','bc','dd','gg'], bolts = ['AB','BC','DD','GG'].

 we will tell you the match compare function. If we give you another compare function.

 the possible return is the following:

 nuts = ['ab','bc','dd','gg'], bolts = ['BC','AA','DD','GG'].

 So you must use the compare function that we give to do the sorting.

 The order of the nuts or bolts does not matter
 */
public class NutsAndBoltsCompare {
    public void sortNutsAndBolts(String[] a, String[] b, NBComparator compare) {
        int n = a.length;
        if(n != b.length || n <= 1) return;

        quickSort(a, b, 0, n-1, compare);
    }

    private void quickSort(String[] a, String[] b, int l, int r, NBComparator compare) {
        if(l>=r) return;

        int p = r;
        int firstLarge = l;
        int i = l;
        while(i<r){
            int result = compare.cmp(a[p], b[i]);
            if(result > 0) {
                i++;
            } else if(result < 0) {
                swap(b, i++, firstLarge++);
            } else {
                swap(b, i, r);
            }
        }

        swap(a, firstLarge, r);
        swap(b, firstLarge, r);
        quickSort(a, b, l, firstLarge-1, compare);
        quickSort(a, b, firstLarge+1, r, compare);
    }

    private void swap(String[] a, int i, int j) {
        String tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    private class NBComparator {
        public int cmp(String a, String b) {
            return 0;
        }
    }
}
