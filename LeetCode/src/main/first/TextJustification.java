package first;
import java.util.ArrayList;

public class TextJustification {
	public ArrayList<String> fullJustify(String[] words, int l) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<String> result = new ArrayList<String>();
		ArrayList<String> line = new ArrayList<String>();

		int count = 0;
		int i = 0;
		while (i < words.length) {
			String word = words[i];
			if (count + word.length() + line.size() > l) {
				addResult(result, line, count, l, true);
				count = 0;
				line.clear();
			} else {
				line.add(word);
				count += word.length();
				i++;
			}
		}
		if (line.size() > 0) {
			addResult(result, line, count, l, false);
		}
		return result;
	}

	void addResult(ArrayList<String> result, ArrayList<String> line, int count,
			int l, boolean flag) {
		int n = line.size();
		int diff = l - count - (n - 1);
		int extra = 0;
		int more = 0;
		if (flag && n > 1) {
			extra = diff / (n - 1);
			more = diff % (n - 1);
		}
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < n; i++) {
			String w = line.get(i);
			sb.append(w);
			if (i < n - 1) {
				sb.append(" ");

				if (flag && extra > 0) {
					addSpaces(sb, extra);
				}

				if (flag && more > 0) {
					sb.append(" ");
					more--;
				}
			}
		}

		if (sb.length() < l) {
			addSpaces(sb, l - sb.length());
		}
		result.add(sb.toString());
	}

	void addSpaces(StringBuffer sb, int n) {
		for (int i = 0; i < n; i++) {
			sb.append(" ");
		}
	}
}
