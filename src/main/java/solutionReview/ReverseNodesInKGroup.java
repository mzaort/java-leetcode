package solutionReview;

public class ReverseNodesInKGroup {
	public static void main(String[] args) {
		ListNode n1 = new ListNode(0);
		ListNode n2 = new ListNode(1);
		ListNode n3 = new ListNode(2);
		n1.next = n2;
		n2.next = n3;
		n3.next = null;
		ReverseNodesInKGroup rn = new ReverseNodesInKGroup();
		ListNode res = rn.reverseKGroup(n1, 3);
	}

	public ListNode reverseKGroup(ListNode head, int k) {
		if (head == null || head.next == null || k <= 1) return head;
		ListNode first = new ListNode(0);
		first.next = head;

		ListNode p = first, q, r, t, s;
		while (true) {
			q = p;
			int cur = 0;
			while (cur < k && q != null) {
				cur++;
				q = q.next;
			}
			if (q == null) {
				break;
			}

			r = p.next;
			t = r.next;
			r.next = q.next;
			q.next = null;
			while (t != null) {
				s = t.next;
				t.next = p.next;
				p.next = t;
				t = s;
			}
			p = r;
		}
		return first.next;
	}
}