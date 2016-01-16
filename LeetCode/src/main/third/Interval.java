package third;

public class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }

    @Override
    public boolean equals(Object o){
        if(!(o instanceof Interval)) return false;

        Interval interval = (Interval)o;
        return interval.start == start && interval.end == end;
    }
}