package googleCode;

public class RemoveDuplicatesfromSortedList {
	public ListNode deleteDuplicates(ListNode head) {
		ListNode p = head;
		while (p != null && p.next != null) {
			if (p.val == p.next.val) {
				p.next = p.next.next;
			} else {
				p = p.next;
			}
		}
		return head;
	}

	public ListNode deleteDuplicates2(ListNode head) {
		if (head == null) return null;
		ListNode f = new ListNode(head.val - 1);
		ListNode p = head, r = f, q;
		while (p != null) {
			q = p.next;
			if (r.val != p.val) {
				r.next = p;
				r = r.next;
			}
			p = q;
		}
		r.next = null;
		return f.next;
	}
}
