package solution;

public class PartitionList {
	public ListNode partition(ListNode head, int x) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (head == null || head.next == null) return head;
		ListNode p, q, r, t;
		ListNode first = new ListNode(0);
		first.next = head;

		p = first;
		q = head;
		while (q != null && q.val < x) {
			p = p.next;
			q = q.next;
		}

		if (q != null) {
			r = q.next;
			q.next = null;
			while (r != null) {
				t = r.next;
				if (r.val < x) {
					r.next = p.next;
					p.next = r;
					p = r;
				} else {
					r.next = q.next;
					q.next = r;
					q = r;
				}
				r = t;
			}
		}
		return first.next;
	}
}
