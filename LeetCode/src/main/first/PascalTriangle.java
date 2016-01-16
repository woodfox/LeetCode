package first;
import java.util.ArrayList;
import java.util.Arrays;

public class PascalTriangle {
	public ArrayList<ArrayList<Integer>> generate(int k) {
		ArrayList<ArrayList<Integer>> r = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < k; i++) {
			ArrayList<Integer> row = new ArrayList<Integer>();
			row.add(1);
			if (i > 0) {
				ArrayList<Integer> prev = r.get(i - 1);
				for (int j = 1; j < prev.size(); j++) {
					int x = prev.get(j);
					int y = prev.get(j - 1);
					row.add(x + y);
				}
				row.add(1);
			}
			r.add(row);
		}
		
		return r;
	}
}
