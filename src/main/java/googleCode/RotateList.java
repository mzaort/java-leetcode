package googleCode;

public class RotateList {
	public ListNode rotateRight(ListNode head, int n) {
		assert (n >= 0);

		ListNode first = new ListNode(0);
		first.next = head;
		int length = 0;
		ListNode p = first;
		for (; p.next != null; p = p.next, length++);

		if (length == 0 || n % length == 0) return head;

		int shift = n % length;
		p.next = first.next;
		p = first;
		for (int i = 0; i < length - shift; i++, p = p.next);
		first.next = p.next;
		p.next = null;

		return first.next;
	}
}
