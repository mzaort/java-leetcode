package microsoft;

public class ComplexNode {
	char val;
	ComplexNode next;
	ComplexNode sibling;

	public ComplexNode(char val) {
		this.val = val;
	}

	public ComplexNode clone(ComplexNode src) {
		if (src == null) return null;

		ComplexNode p, q, dst, r, s;
		dst = new ComplexNode(src.val);
		p = src.next;
		q = dst;
		while (p != null) {
			q.next = new ComplexNode(p.val);
			q = q.next;
			p = p.next;
		}
		q.next = null;

		for (p = src, q = dst; p != null; p = p.next, q = q.next) {
			if (p.sibling == null) {
				q.sibling = null;
			} else {
				for (r = src, s = dst; r != null && r != p.sibling; r = r.next, s = s.next);
				q.sibling = s;
			}
		}

		return dst;
	}

	public static void main(String[] args) {
		ComplexNode A = new ComplexNode('A');
		ComplexNode B = new ComplexNode('B');
		ComplexNode C = new ComplexNode('C');
		ComplexNode D = new ComplexNode('D');
		ComplexNode E = new ComplexNode('E');
		A.next = B;
		B.next = C;
		C.next = D;
		D.next = E;
		A.sibling = C;
		B.sibling = E;
		C.sibling = null;
		D.sibling = B;
		E.sibling = null;

		ComplexNode dst = A.clone(A);
		System.out.println(dst.val);
	}

}