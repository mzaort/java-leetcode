package googleCode;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergekSortedLists {
	public ListNode mergeKLists(List<ListNode> lists) {
		while (lists.remove(null));
		if (lists.size() == 0) return null;

		ListNode head = new ListNode(0);
		ListNode p = head, top = null;
		PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.size(), new Comparator<ListNode>() {
			@Override
			public int compare(ListNode o1, ListNode o2) {
				if (o1.val > o2.val) return 1;
				else if (o1.val == o2.val) return 0;
				else return -1;
			}
		});
		queue.addAll(lists);

		while ((top = queue.poll()) != null) {
			if (top.next != null) queue.add(top.next);
			p.next = top;
			p = top;
		}

		p.next = null;
		return head.next;
	}
}
