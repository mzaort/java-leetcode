package googleCode;

public class PopulatingNextRightPointersinEachNode {
	public void connect(TreeLinkNode root) {
		if (root == null) return;

		TreeLinkNode p = root;
		while (p.left != null) {
			TreeLinkNode q = p;
			while (q != null) {
				q.left.next = q.right;
				if (q.next != null) q.right.next = q.next.left;
				q = q.next;
			}
			p = p.left;
		}
	}
}
