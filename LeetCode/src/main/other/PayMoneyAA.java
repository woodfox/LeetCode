package other;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 如果你和另外两个朋友出去玩，每个人付一部分钱，比如你掏了car rent， 另一个人付了hotel等等。
 * 最后回家了，你们想AA，最后你们每个人付的钱都一样，写个方法能返回谁应该给谁多少钱
 * 比如三个人分别掏了5，3，1，那么a[2]应该给a[0] 2 刀 如果现在有n个人的话，应该怎么办
 *
 * Follow up:
 * 如果每次transaction特别麻烦，不管是时间还是空间都特别麻烦。如果不用考虑everything， 不考虑cpu， 不考虑硬盘，我们想让这个次数最少，怎么办。
 */
public class PayMoneyAA {
    /**
     * Get the money to pay and allocate to other people.
     *
     * Time: O(n)
     *
     * Follow up: To get the minimum transactions, we should save the differences in map, and try to find exact-matched money first,
     *  before using partial-matched money.
     */
    public List<Pay> payMoney(int[] a) {
        List<Pay> r = new ArrayList();
        int n = a.length;
        if(n<=1) return r;

        int sum = 0;
        for(int x : a) sum += x;
        double average = (double)sum/n;

        LinkedList<Integer> fromQueue = new LinkedList();
        LinkedList<Double> moneyQueue = new LinkedList();
        // Add persons that need to pay
        for(int i=0;i<n;i++){
            if(a[i] < average) {
                fromQueue.add(i);
                moneyQueue.add(average-a[i]);
            }
        }

        // Check persons that need to get money
        for(int i=0;i<n;i++){
            if(a[i] > average){
                double diff = a[i] - average;
                while(diff > 0.000000001) {
                    int pos = fromQueue.removeFirst();
                    double money = moneyQueue.removeFirst();
                    if(diff >= money) {
                        // Full fill
                        diff -= money;
                        r.add(new Pay(pos, i, money));
                    } else {
                        // Partial fill
                        r.add(new Pay(pos, i, diff));
                        money -= diff;
                        diff = 0;

                        // Add not use all the money. Add the remaining into the queue
                        fromQueue.addFirst(pos);
                        moneyQueue.addFirst(money);
                    }
                }
            }
        }

        return r;
    }

    public static class Pay {
        public int from;
        public int to;
        public double money;

        public Pay(int f, int t, double m) {
            this.from = f;
            this.to = t;
            this.money = m;
        }

        @Override
        public boolean equals(Object o) {
            if(o==null) return false;
            if(!(o instanceof Pay)) return false;
            Pay p = (Pay)o;

            return p.from == this.from
                    && p.to == this.to
                    && Math.abs(p.money-this.money) < 0.00000000001;
        }

        @Override
        public String toString() {
            return "[" + from + "->" + to + ":" + money + "]";
        }
    }
}
