package googleCode;

public class ConvertSortedListtoBinarySearchTree {
	public TreeNode sortedListToBST(ListNode head) {
		return sortedListToBST(head, null);
	}

	private TreeNode sortedListToBST(ListNode head, ListNode end) {
		if (head == end) return null;
		ListNode p = head, q = head;
		while (p != end && p.next != end) {
			p = p.next.next;
			q = q.next;
		}
		TreeNode node = new TreeNode(q.val);
		node.left = sortedListToBST(head, q);
		node.right = sortedListToBST(q.next, end);
		return node;
	}

	public TreeNode sortedListToBST2(ListNode head) {
		return sortedListToBST(getLength(head), new ListNode[] { head });
	}

	private TreeNode sortedListToBST(int len, ListNode[] cur) {
		if (len == 0) return null;
		TreeNode left = sortedListToBST(len / 2, cur);
		TreeNode node = new TreeNode(cur[0].val);
		cur[0] = cur[0].next;
		TreeNode right = sortedListToBST(len - 1 - len / 2, cur);
		node.left = left;
		node.right = right;
		return node;
	}

	private int getLength(ListNode head) {
		int len = 0;
		for (ListNode p = head; p != null; p = p.next, len++);
		return len;
	}
}
