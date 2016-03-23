package other;

import util.Point;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Tries {
    class Node {
        char c;
        boolean isLeaf = false;
        Map<Character, Node> map = new HashMap<Character, Node>();

        public Node(char d) {
            this.c = d;
        }
    }

    private Node root = new Node(' ');

    public void add(String s) {
        if(s != null) {
            insert(root, s);
        }
    }

    private void insert(Node node, String s) {
        if(s.length() > 0) {
            char c = s.charAt(0);
            Node child = node.map.get(c);
            if(child == null) {
                child = new Node(c);
                node.map.put(c, child);
            }
            insert(child, s.substring(1));
        } else {
            node.isLeaf = true;
        }
    }

    public boolean contains(String s) {
        if(s == null) {
            return false;
        } else {
            return checkNode(root, s);
        }
    }

    private boolean checkNode(Node node, String s){
        if(s.length() == 0) {
            return node.isLeaf;
        } else {
            Node child = node.map.get(s.charAt(0));
            if(child == null) {
                return false;
            } else {
                return checkNode(child, s.substring(1));
            }
        }
    }

    public static class MaxPointsInLine {
        public int maxPoints(Point[] a) {
            if(a == null || a.length==0) return 0;

            int max = 0;
            for(int i=0;i<a.length;i++){
                Map<Line, Integer> map = new HashMap();
                Point p = a[i];
                int self = 1;
                int others = 0;
                for(int j=i+1;j<a.length;j++){
                    Point q = a[j];
                    if(p.x == q.x && p.y == q.y){
                        self++;
                        continue;
                    }
                    Line l = new Line(p, q);
                    if(!map.containsKey(l)){
                        map.put(l, 1);
                    }else{
                        map.put(l, map.get(l)+1);
                    }
                    others = Math.max(others, map.get(l));
                }
                // Have to calculate total max at last!
                max = Math.max(max, self + others);
            }
            return max;
        }

        class Line {
            double k;
            double c;
            public Line(Point a, Point b){
                if(a.x == b.x){
                    k = Double.MAX_VALUE;
                    c = a.x;
                }else if(a.y == b.y){
                    k =0;
                    c = a.y;
                }else{
                    k = ((double)(a.y-b.y))/(a.x-b.x);
                    c = a.y - k*a.x;
                }
            }

            @Override
            public boolean equals(Object o){
                if(!(o instanceof Line)) return false;
                double MIN_DIFF = 0.0000000001;

                Line l = (Line)o;
                return Math.abs(k-l.k)< MIN_DIFF && Math.abs(c-l.c)<MIN_DIFF;
            }

            @Override
            public int hashCode(){
                return (int)(k*31+c);
            }

            @Override
            public String toString() {
                return "k:" + k + ",c:" + c;
            }
        }
    }

    public static class MedianSelector {
        public int[] medianII(int[] nums) {
            Median m = new Median();

            int n = nums.length;
            int[] r = new int[n];
            for(int i=0;i<n;i++) {
                m.insert(nums[i]);
                r[i] = m.getMedian();
            }

            return r;
        }

        private class Median {
            PriorityQueue<Integer> maxQueue = new PriorityQueue(10, new Comparator<Integer>(){
                @Override
                public int compare(Integer a, Integer b) {
                    return b-a;
                }
            });
            PriorityQueue<Integer> minQueue = new PriorityQueue();

            public void insert(int x) {
                if(maxQueue.isEmpty() || x <= maxQueue.peek()){
                    maxQueue.add(x);
                    if(maxQueue.size() > minQueue.size()+1){
                        minQueue.add(maxQueue.poll());
                    }
                }else {
                    minQueue.add(x);
                    if(maxQueue.size() < minQueue.size()){
                        maxQueue.add(minQueue.poll());
                    }
                }
            }
            public int getMedian() {
                return maxQueue.peek();
            }
        }
    }
}
