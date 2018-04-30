package googleCode;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle {
	public boolean hasCycle(ListNode head) {
		Set<ListNode> set = new HashSet<ListNode>();
		ListNode p = head;
		while (p != null) {
			if (set.contains(p)) return true;
			set.add(p);
			p = p.next;
		}
		return false;
	}

	public boolean hasCycle2(ListNode head) {
		ListNode p = head, q = head;
		while (p != null && p.next != null) {
			p = p.next.next;
			q = q.next;
			if (p == q) return true;
		}
		return false;
	}
}
