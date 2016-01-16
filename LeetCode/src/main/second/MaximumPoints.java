package second;

import java.util.HashMap;

public class MaximumPoints {
	class Point {
		 int x;
		 int y;
		 Point() { x = 0; y = 0; }
		 Point(int a, int b) { x = a; y = b; }
	}

	class Line {
		final double MIN_DIFF = 0.000001;
		double angle;
		
		public Line(int x, int y){
			if(x == 0){
				angle = Double.MAX_VALUE;
			}else{
				angle = (double)y/x;
			}
		}
		
		public int hashCode(){
			return (int)(17 + angle);
		}
		
		public boolean equals(Object o){
	        if (o == null){
	            return false;
	        }
	        if (o == this){
	            return true;
	        }
	        if (!(o instanceof Line)){
	            return false;
	        }
	        
			Line p = (Line)o;
			if(Math.abs(p.angle - this.angle) <= MIN_DIFF){
				return true;
			}
			return false;
		}
	}
	
    public int maxPoints(Point[] a){
    	int n = a.length;
    	if(n == 0){
    		return 0;
    	}
    	
    	int max = 0;
    	for(int i=0;i<n;i++){
    		int x = a[i].x;
    		int y = a[i].y;
    		int base = 1;
    		int singleMax = 0;
    		HashMap<Line, Integer> map = new HashMap<Line, Integer>();
    		for(int j=i+1;j<n;j++){
    			int x2 = a[j].x - x;
    			int y2 = a[j].y - y;
    			if(x2 == 0 && y2 == 0){
    				base++;
    				continue;
    			}
    			
    			Line l = new Line(x2, y2);
    			Integer count = map.get(l);
    			if(count == null){
    				count = 0;
    			}
    			map.put(l, count+1);
    			singleMax = Math.max(singleMax, count+1);
    		}
    		max = Math.max(max, singleMax+base);
    	}
    	return max;
    }
}
