package first;
import java.util.HashMap;

public class CopyRandomList {
	// Definition for singly-linked list with a random pointer.
	class RandomListNode {
		int label;
		RandomListNode next, random;

		RandomListNode(int x) {
			this.label = x;
		}
	};

	public RandomListNode copyRandomList(RandomListNode head) {
		// Note: The Solution object is instantiated only once and is reused by
		// each test case.
		if (head == null) {
			return null;
		}
		HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
		RandomListNode newHead = new RandomListNode(head.label);
		map.put(head, newHead);
		RandomListNode oldNode = head;
		RandomListNode newNode = newHead;
		while (oldNode != null) {
			newNode.next = copyNode(oldNode.next, map);
			newNode.random = copyNode(oldNode.random, map);
			oldNode = oldNode.next;
			newNode = newNode.next;
		}
		return newHead;
	}

	private RandomListNode copyNode(RandomListNode old,
			HashMap<RandomListNode, RandomListNode> map) {
		if (old == null) {
			return null;
		}
		RandomListNode newNode = map.get(old);
		if (newNode == null) {
			newNode = new RandomListNode(old.label);
			map.put(old, newNode);
		}
		return newNode;
	}
	
	public void main(String[] args){
		CopyRandomList c = new CopyRandomList();
		RandomListNode head = new RandomListNode(1);
		RandomListNode second = new RandomListNode(2);
		RandomListNode third = new RandomListNode(3);
		RandomListNode fouth = new RandomListNode(4);
		head.next = second;
		head.random = third;
		second.next = third;
		second.random = null;
		third.next = fouth;
		third.random = head;
		fouth.next = null;
		fouth.random = fouth;
		
		RandomListNode newHead = c.copyRandomList(head);
		while(newHead != null){
			System.out.println("newNode label: " + newHead.label);
			if(newHead.next != null){
				System.out.println("    , next:" + newHead.next);
			}else {
				System.out.println("    , next: NULL");
			}
			
			if(newHead.random != null){
				System.out.println("    , random:" + newHead.random);
			}else {
				System.out.println("    , random: NULL");
			}
			newHead = newHead.next;
		}
	}
}
