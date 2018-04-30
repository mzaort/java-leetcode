package googleCode;

public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode res = new ListNode(0);

		ListNode p = res;
		int surplus = 0;
		while (l1 != null && l2 != null) {
			int val = l1.val + l2.val + surplus;
			surplus = val / 10;

			p.next = new ListNode(val % 10);
			p = p.next;
			l1 = l1.next;
			l2 = l2.next;
		}

		while (l1 != null) {
			int val = l1.val + surplus;
			surplus = val / 10;

			p.next = new ListNode(val % 10);
			p = p.next;
			l1 = l1.next;
		}

		while (l2 != null) {
			int val = l2.val + surplus;
			surplus = val / 10;

			p.next = new ListNode(val % 10);
			p = p.next;
			l2 = l2.next;
		}

		if (surplus != 0) {
			p.next = new ListNode(surplus);
			p = p.next;
		}

		p.next = null;
		return res.next;
	}
}
