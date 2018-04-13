package solution;

public class RotateList {
	public ListNode rotateRight(ListNode head, int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if(n == 0) return head;
		if(head == null || head.next == null) return head;
		
		ListNode p, q = null, r;

		int length = 0;
		p = head;
		while (p != null) {
			q = p;
			p = p.next;
			length++;
		}		
		q.next = head;

		n = n % length;

		p = head;
		int i = 1, lim = length - n;
		while (i < lim) {
			p = p.next;
			i++;
		}

		r = p.next;
		p.next = null;
		
		return r;

	}
}
