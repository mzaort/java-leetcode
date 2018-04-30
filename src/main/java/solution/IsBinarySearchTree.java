package solution;

public class IsBinarySearchTree {

	public static void main(String[] args) {
		IsBinarySearchTree ibst = new IsBinarySearchTree();
		System.out.println(ibst.isBST(new int[] { 0, 2, 1, 4, 6, 9, 1, 10, 7 }));
	}

	public boolean isBST(int[] num) {
		return isBST(num, 0, num.length - 1);
	}

	public boolean isBST(int[] num, int frm, int end) {
		if (frm >= end) {
			return true;
		} else {
			int top = num[end];
			int split = frm;
			for (; split < end && num[split] < top; split++);
			if (split == end) {
				return isBST(num, frm, end - 1);
			} else {
				for (int i = split; i < end; i++) {
					if (num[i] <= top) { return false; }
				}
				return isBST(num, frm, split - 1) && isBST(num, split, end - 1);
			}
		}
	}

	public boolean isBST2(int[] num, int frm, int end) {
		if (frm <= end) return true;
		int i = frm;
		for (; i < end && num[i] < num[end]; i++);
		if (!isBST2(num, frm, i - 1)) return false;
		int j = i;
		for (; num[j] > num[end]; j++);
		if (j != end) return false;
		return isBST2(num, i, j - 1);
	}
}
