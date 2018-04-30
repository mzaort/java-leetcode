package interview2016;

public class ReverseLinkedList {
	public ListNode reverseList(ListNode head) {
		ListNode f = new ListNode(0);
		ListNode p = head, q = null;
		while (p != null) {
			q = p.next;
			p.next = f.next;
			f.next = p;
			p = q;
		}
		return f.next;
	}
}
