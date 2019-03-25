package interview2018;

public class RotateList {
	public ListNode rotateRight(ListNode head, int k) {
		if (head == null || head.next == null || k <= 0) return head;
		ListNode first = new ListNode(0);
		first.next = head;

		int c = 0;
		ListNode p = first, q = first;
		for (; c < k && p != null; c++, p = p.next);
		if (p == null) {
			int len = c - 1;
			k = k % len;
			if (k == 0) return head;
			p = first;
			c = 0;
			for (; c < k && p != null; c++, p = p.next);
		}
		for (; p.next != null; p = p.next, q = q.next);
		if (q == first) return head;
		p.next = first.next;
		first.next = q.next;
		q.next = null;

		return first.next;
	}
}
