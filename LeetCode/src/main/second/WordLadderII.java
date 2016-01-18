package second;

import java.util.*;

public class WordLadderII {
	enum Color {
		WHITE, GREY, BLACK
	};

	class Node {
		String val;
		ArrayList<Node> adj = new ArrayList<Node>();
		ArrayList<Node> parents = new ArrayList<Node>();
		Color color = Color.WHITE;
		int level = 0;
		Node prev;

		public Node(String s) {
			val = s;
		}
	}

	public List<List<String>> findLadders(String start, String end,
			HashSet<String> dict) {
		dict.add(start);
		dict.add(end);
		HashMap<String, Node> map = buildMap(dict);

		return bfs(map.get(start), map.get(end));
	}

	HashMap<String, Node> buildMap(HashSet<String> dict) {
		HashMap<String, Node> map = new HashMap<String, Node>();
		for (String s : dict) {
			map.put(s, new Node(s));
		}

		for (String s : map.keySet()) {
			Node node = map.get(s);
			StringBuffer sb = new StringBuffer(s);
			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				for (int j = 0; j < 26; j++) {
					if (c == 'a' + j) {
						continue;
					}
					sb.setCharAt(i, (char) ('a' + j));

					if (dict.contains(sb.toString())) {
						Node next = map.get(sb.toString());
						node.adj.add(next);
						next.adj.add(node);
					}
				}
				sb.setCharAt(i, c);
			}
			dict.remove(s);
		}
		return map;
	}

	List<List<String>> bfs(Node start, Node end) {
		LinkedList<Node> q = new LinkedList<Node>();
		start.level = 0;
		q.add(start);
		while (!q.isEmpty()) {
			Node node = q.removeFirst();
			node.color = Color.BLACK;

			for (Node next : node.adj) {
				if (next.color == Color.WHITE) {
					q.add(next);
				}

				if (next.color == Color.WHITE
						|| (next.color == Color.GREY && next.level >= node.level + 1)) {
					next.parents.add(node);
					next.color = Color.GREY;
					next.level = node.level + 1;
				}
			}
		}

		return getLadder(end, start);
	}

	List<List<String>> getLadder(Node end, Node start) {
		List<List<String>> r = new ArrayList<List<String>>();
		if (end == start) {
			ArrayList<String> sub = new ArrayList<String>();
			sub.add(start.val);
			r.add(sub);
		} else {
			for (Node p : end.parents) {
				for (List<String> sub : getLadder(p, start)) {
					sub.add(end.val);
					r.add(sub);
				}
			}
		}
		return r;
	}
}
