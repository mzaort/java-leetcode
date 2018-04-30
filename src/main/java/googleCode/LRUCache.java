package googleCode;

import java.util.*;

public class LRUCache {

	public static void main(String[] args) {
		LRUCache lru = new LRUCache(2);
		lru.set(1, 2);// 1
		lru.set(2, 3);// 2 1
		lru.set(1, 3);// 1 2
		lru.set(3, 2);// 3 1
		System.out.println(lru.get(1));// =3
		System.out.println(lru.get(2));// -1
		System.out.println(lru.get(3));// 2
	}

	private int capacity;
	private Map<Integer, DNode> map;
	private DNode head;

	public LRUCache(int capacity) {
		assert (capacity > 0);
		this.capacity = capacity;
		map = new HashMap<Integer, DNode>();
		head = new DNode();
		head.next = head.previous = head;
	}

	public int get(int key) {
		DNode node = map.get(key);
		if (node == null) return -1;
		node.remove();
		node.add();
		return node.val;
	}

	public void set(int key, int value) {
		DNode node = map.get(key);
		if (node != null) {
			node.val = value;
			node.remove();
			node.add();
		} else {
			if (map.size() == capacity) {
				DNode tmp = head.previous;
				tmp.remove();
				map.remove(tmp.key);
			}
			node = new DNode(key, value);
			node.add();
			map.put(key, node);
		}
	}

	class DNode {
		int val;
		int key;
		DNode previous;
		DNode next;

		public DNode() {}

		public DNode(int key, int val) {
			this.key = key;
			this.val = val;
		}

		public void remove() {
			this.previous.next = this.next;
			this.next.previous = this.previous;
		}

		public void add() {
			this.previous = head;
			this.next = head.next;
			this.previous.next = this;
			this.next.previous = this;
		}
	}

}
