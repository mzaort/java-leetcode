package interview2015;

public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode head = new ListNode(0);
		ListNode p = head;
		int surplus = 0;
		for (; l1 != null && l2 != null; l1 = l1.next, l2 = l2.next, p = p.next) {
			int val = surplus + l1.val + l2.val;
			p.next = new ListNode(val % 10);
			surplus = val / 10;
		}

		for (; l1 != null; l1 = l1.next, p = p.next) {
			int val = surplus + l1.val;
			p.next = new ListNode(val % 10);
			surplus = val / 10;
		}

		for (; l2 != null; l2 = l2.next, p = p.next) {
			int val = surplus + l2.val;
			p.next = new ListNode(val % 10);
			surplus = val / 10;
		}

		if (surplus != 0) p.next = new ListNode(surplus);

		return head.next;
	}
}
