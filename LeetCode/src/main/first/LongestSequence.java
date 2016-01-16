package first;
import java.util.HashMap;
import java.util.Map;

public class LongestSequence {
	int longestConsecutive(int[] a) {
		int max = 0;
		Map<Integer, Seq> start = new HashMap<Integer, Seq>();
		Map<Integer, Seq> end = new HashMap<Integer, Seq>();
		for(int i:a){
			if(start.get(i) != null || end.get(i) != null){
				continue;
			}
			int length = 0;
			Seq prev = end.get(i-1);
			Seq next = start.get(i+1);
			if(prev != null && next != null){
				end.put(prev.end, null);
				start.put(next.start, null);
				prev.end = next.end;
				start.put(prev.start, prev);
				end.put(prev.end, prev);
				length = prev.end - prev.start + 1;
			}else if(prev != null){
				prev.end++;
				end.put(prev.end-1, null);
				end.put(prev.end, prev);
				length = prev.end - prev.start + 1;
			}else if(next != null){
				next.start--;
				start.put(next.start+1, null);
				start.put(next.start, next);
				length = next.end - next.start + 1;
			}else{
				Seq s = new Seq(i, i);
				start.put(i, s);
				end.put(i, s);
				length =1;
			}
			if(max < length){
				max = length;
			}
		}
		return max;
	}
	
	class Seq {
		int start;
		int end;
		
		public Seq(int i, int j){
			start = i;
			end = j;
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LongestSequence s = new LongestSequence();
		int[] a = {100, 4, 200, 1, 3, 2};
		System.out.println("Expected 4:" + s.longestConsecutive(a));
		
		int[] b = {1};
		System.out.println("Expected 1:" + s.longestConsecutive(b));
		
		int[] c = {-3, -5, 100, 1, 3, 7, 9, 2, 1, 6, 2, 8, -4};
		System.out.println("Expected 4:" + s.longestConsecutive(c));
		
		int[] d = {-3, -5, 100, 1, 3, 6, 2, 8, -4};
		System.out.println("Expected 3:" + s.longestConsecutive(d));

		int[] f = {0, -1};
		System.out.println("Expected 2:" + s.longestConsecutive(f));
		
		int[] g = {5,3,9,0,1,-3,-1,7,5,-8,4,-3,8,-9,-6,8,-8};
		System.out.println("Expected 3:" + s.longestConsecutive(g));
		
		//Failed test case
		//System.out.println("Expected 290:" + s.longestConsecutive(h));
	}

}
