package second;

import java.util.HashMap;

public class LongestConsecutive {
	class Node {
		int id;
		Node next;
		boolean visited;

		public Node(int i) {
			id = i;
		}
	}

	public int longestConsecutive(int[] a) {
		HashMap<Integer, Node> map = new HashMap<Integer, Node>();
		for (int x : a) {
			if (map.get(x) == null) {
				Node node = new Node(x);
				Node prev = map.get(x - 1);
				Node next = map.get(x + 1);
				if (prev != null) {
					prev.next = node;
				}
				if (next != null) {
					node.next = next;
				}
				map.put(x, node);
			}
		}

		int max = 0;
		for (Node node : map.values()) {
			if (!node.visited) {
				max = Math.max(max, dfs(node));
			}
		}
		return max;
	}

	private int dfs(Node node) {
		if (node == null) {
			return 0;
		} else {
			node.visited = true;
			return dfs(node.next) + 1;
		}
	}
}
