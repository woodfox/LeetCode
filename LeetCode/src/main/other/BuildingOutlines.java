package other;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BuildingOutlines {
    public ArrayList<ArrayList<Integer>> buildingOutline(int[][] a) {
        // write your code here
        ArrayList<ArrayList<Integer>> r =  new ArrayList();
        int n = a.length;
        if(n==0) return r;

        // Position queue ordered with x
        PriorityQueue<int[]> positionQueue = new PriorityQueue<int[]>(n, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                return a[0] - b[0];
            }
        });

        for(int[] block:a){
            positionQueue.add(new int[]{block[0], block[2]});
            positionQueue.add(new int[]{block[1], -block[2]});
        }

        // Height queue with max order
        PriorityQueue<Integer> heightQueue = new PriorityQueue<Integer>(n, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return b-a;
            }
        });
        int start = 0;
        int prevHeight = 0;
        while(!positionQueue.isEmpty()){
            int[] pos = positionQueue.poll();
            int x = pos[0];
            int h = pos[1];

            if(h>0){
                heightQueue.add(h);
                if(prevHeight == 0) start = pos[0];
            }else{
                heightQueue.remove(-h);
            }

            if(!positionQueue.isEmpty() && x == positionQueue.peek()[0]) {
                // skip the operation on same X!
                continue;
            }

            int current = 0;
            if(!heightQueue.isEmpty()) current = heightQueue.peek();

            // When adding or removing height, it may change differently in same X!
            if(prevHeight != 0 && prevHeight != current){
                ArrayList<Integer> sub = new ArrayList();
                sub.add(start);
                sub.add(x);
                sub.add(prevHeight);
                r.add(sub);
                start = x;
            }

            prevHeight = current;
        }
        return r;
    }
}
