package googleCode;

public class LinkedListCycleII {
	public ListNode detectCycle(ListNode head) {
		ListNode p = head, q = head;
		while (p != null && p.next != null) {
			p = p.next.next;
			q = q.next;
			if (p == q) {
				p = head;
				while (p != q) {
					p = p.next;
					q = q.next;
				}
				return p;
			}
		}
		return null;
	}
}
