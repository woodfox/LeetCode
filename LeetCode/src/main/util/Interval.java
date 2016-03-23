package util;

public class Interval {
    public int start;
    public int end;

    public Interval() {
        start = 0;
        end = 0;
    }

    public Interval(int s, int e) {
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