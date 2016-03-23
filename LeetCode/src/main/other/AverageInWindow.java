package other;

import java.util.LinkedList;

/**
 * 每次用户会调用一个方法 double next(double v) 然后函数返回的是这个数之前的 windowSize个数的average
 比如windowSize是3，call了 next(10) next(11) next(3) call(1), 第一个返回 10， 第二个返回 10.5， 第三个返回 8， 第四个返回 5
 */
public class AverageInWindow {
    LinkedList<Integer> q = new LinkedList();
    int sum = 0;
    int windowSize;

    public AverageInWindow(int windowSize) {
        this.windowSize = windowSize;
    }

    public double next(int x) {
        sum += x;
        q.add(x);

        if(q.size() > windowSize) {
            int y = q.removeFirst();
            sum -= y;
        }

        return sum/q.size();
    }
}
