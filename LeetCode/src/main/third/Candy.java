package third;

public class Candy {
    /**
     * left(i) and right(i) are elements on nearby left/right that has lower priorities.
     * What should we do if ratings nearby are same??  Looks like we can give next one as only one candy.
     *
     *           | 0   i == 0
     * left(i) = | left(i-1) + 1,    if a[i] >= a[i-1]
     *           | 0                 if a[i] = a[i-1]
     *           | 0                 else
     *
     *            | 0   i == n-1
     * right(i) = | right(i+1) + 1,  if a[i] >= a[i+1]
     *            | 0                if a[i] = a[i+1]
     *            | 0                else
     *
     * Then total candy = Sum(max(left(i), right(i)) + 1) (starting from one candy)
     *
     */
    public int candy(int[] ratings) {
        int n = ratings.length;
        if(n == 0) {
            return 0;
        }

        int[] left = new int[n];
        left[0] = 0;
        for(int i=1;i<n;i++) {
            if(ratings[i] > ratings[i-1]) {
                left[i] = left[i-1] + 1;
            }else if(ratings[i] == ratings[i-1]) {
                left[i] = 0;
            } else {
                left[i] = 0;
            }
        }

        int[] right = new int[n];
        right[n-1] = 0;
        for(int i=n-2;i>=0;i--){
            if(ratings[i] > ratings[i+1]) {
                right[i] = right[i+1] + 1;
            } else if(ratings[i] == ratings[i+1]) {
                right[i] = 0;
            } else {
                right[i] = 0;
            }
        }

        int sum = 0;
        for(int i=0;i<n;i++){
            sum += Math.max(left[i], right[i]) + 1;
        }
        return sum;
    }
}
