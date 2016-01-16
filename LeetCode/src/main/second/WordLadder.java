package second;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class WordLadder {
	enum Color {
		WHITE, GREY, BLACK
	};

	class Node {
		String val;
		ArrayList<Node> adj = new ArrayList<Node>();
		Color color = Color.WHITE;
		Node prev;

		public Node(String s) {
			val = s;
		}
	}

	public int ladderLength(String start, String end, HashSet<String> dict) {
		dict.add(start);
		dict.add(end);
		HashMap<String, Node> map = buildMap(dict);

		Node s = map.get(start);
		Node e = map.get(end);
		return bfs(s, e);
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
					if (map.get(sb.toString()) != null) {
						node.adj.add(map.get(sb.toString()));
					}
				}
				sb.setCharAt(i, c);
			}
		}
		return map;
	}

	int bfs(Node start, Node end) {
		LinkedList<Node> q = new LinkedList<Node>();
		q.add(start);
		while (!q.isEmpty()) {
			Node node = q.removeFirst();
			node.color = Color.BLACK;
			if (node == end) {
				return getLength(end, start);
			}

			for (Node next : node.adj) {
				if (next.color == Color.WHITE) {
					next.color = Color.GREY;
					next.prev = node;
					q.add(next);
				}
			}
		}

		return 0;
	}

	int getLength(Node end, Node start) {
		int count = 0;
		Node node = end;
		while (node != null) {
			count++;
			node = node.prev;
		}
		return count;
	}
}
