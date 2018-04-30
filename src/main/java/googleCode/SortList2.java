package googleCode;

public class SortList2 {
	public ListNode sortList(ListNode head) {
		if (head == null || head.next == null) return head;

		ListNode p = head, q = head;
		while (p.next != null && p.next.next != null) {
			p = p.next.next;
			q = q.next;
		}
		p = q.next;
		q.next = null;
		ListNode list1 = sortList(head);
		ListNode list2 = sortList(p);

		ListNode first = new ListNode(0);
		ListNode r = first;
		while (list1 != null && list2 != null) {
			if (list1.val < list2.val) {
				r.next = list1;
				list1 = list1.next;
			} else {
				r.next = list2;
				list2 = list2.next;
			}
			r = r.next;
		}
		r.next = list1 == null ? list2 : list1;

		return first.next;
	}

	public ListNode sortList2(ListNode head) {
		if (head == null || head.next == null) return head;
		ListNode[] list = divide(head);
		ListNode list1 = sortList2(list[0]);
		ListNode list2 = sortList2(list[1]);
		ListNode res = merge(list1, list2);
		return res;
	}

	private ListNode merge(ListNode list1, ListNode list2) {
		ListNode first = new ListNode(0);
		ListNode r = first;
		while (list1 != null && list2 != null) {
			if (list1.val < list2.val) {
				r.next = list1;
				list1 = list1.next;
			} else {
				r.next = list2;
				list2 = list2.next;
			}
			r = r.next;
		}
		r.next = list1 == null ? list2 : list1;

		return first.next;
	}

	private ListNode[] divide(ListNode head) {// not null;
		ListNode[] res = { head, null };
		ListNode p = head, q = head;
		while (p != null && p.next != null && p.next.next != null) {
			p = p.next.next;
			q = q.next;
		}
		res[1] = q.next;
		q.next = null;
		return res;
	}
}
