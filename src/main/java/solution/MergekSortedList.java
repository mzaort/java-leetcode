package solution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MergekSortedList {
	public ListNode mergeKLists(ArrayList<ListNode> lists) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ListNode head = new ListNode(0);
		ListNode p = head;

		ListNode[] array = lists.toArray(new ListNode[0]);
		ListNode[] ptr = new ListNode[array.length];

		int top = -1;
		for (int i = 0; i < array.length; i++) {
			if (array[i] != null) {
				top++;
				for (int j = top; j >= 0; j--) {
					if (j == 0 || ptr[j - 1].val >= array[i].val) {
						ptr[j] = array[i];
						break;
					} else {
						ptr[j] = ptr[j - 1];
					}
				}
			}
		}

		while (top != -1) {
			p.next = ptr[top];
			p = ptr[top];
			ListNode q = ptr[top].next;
			top--;
			if (q != null) {
				top++;
				for (int j = top; j >= 0; j--) {
					if (j == 0 || ptr[j - 1].val >= q.val) {
						ptr[j] = q;
						break;
					} else {
						ptr[j] = ptr[j - 1];
					}
				}
			}
		}
		p.next = null;

		return head.next;
	}

	public ListNode mergeKLists2(ArrayList<ListNode> lists) {
		ListNode head = new ListNode(0);
		ListNode p = head;

		while (lists.remove(null));

		Comparator<ListNode> cp = new Comparator<ListNode>() {
			@Override
			public int compare(ListNode o1, ListNode o2) {
				if (o1.val > o2.val) {
					return -1;
				} else if (o1.val == o2.val) {
					return 0;
				} else {
					return 1;
				}
			}
		};

		Collections.sort(lists, cp);

		int min = 0;
		while ((min = lists.size()) != 0) {
			ListNode q = lists.get(min - 1);
			p.next = q;
			p = p.next;
			if (q.next == null) {
				lists.remove(min - 1);
			} else {
				lists.set(min - 1, q.next);
			}
			Collections.sort(lists, cp);
		}
		p.next = null;
		return head.next;
	}

	public ListNode mergeKLists3(ArrayList<ListNode> lists) {
		ListNode head = new ListNode(0);
		ListNode p = head;

		while (lists.remove(null));

		Comparator<ListNode> cp = new Comparator<ListNode>() {
			@Override
			public int compare(ListNode o1, ListNode o2) {
				if (o1.val > o2.val) {
					return -1;
				} else if (o1.val == o2.val) {
					return 0;
				} else {
					return 1;
				}
			}
		};

		Collections.sort(lists, cp);

		int min = 0;
		while ((min = lists.size()) != 0) {
			ListNode q = lists.get(min - 1);
			p.next = q;
			p = p.next;
			if (q.next == null) {
				lists.remove(min - 1);
			} else {
				int i = min - 2;
				for (; i >= 0 && lists.get(i).val < q.next.val; i--)
					lists.set(i + 1, lists.get(i));
				lists.set(i + 1, q.next);
			}
		}
		p.next = null;
		return head.next;
	}
}
