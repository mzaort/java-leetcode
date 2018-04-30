package googleCode;

public class SwapNodesinPairs {
	public ListNode swapPairs(ListNode head) {
		ListNode first = new ListNode(0);
		first.next = head;

		ListNode p, q, r, s;
		p = first;
		while (p != null && (q = p.next) != null && (r = q.next) != null) {
			s = r.next;
			p.next = r;
			r.next = q;
			q.next = s;
			p = q;
		}

		return first.next;
	}
}
