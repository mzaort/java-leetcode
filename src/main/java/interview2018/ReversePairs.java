package interview2018;

public class ReversePairs {
	public int reversePairs(int[] nums) {
		return reversePairs(nums, 0, nums.length - 1);
	}

	private int reversePairs(int[] nums, int i, int j) {
		if (i < j) {
			int mid = i + ((j - i) >>> 1);
			int c1 = reversePairs(nums, i, mid);
			int c2 = reversePairs(nums, mid + 1, j);
			int c3 = merge(nums, i, mid, j);
			return c1 + c2 + c3;
		}
		return 0;
	}

	private int merge(int[] a, int frm, int mid, int end) {
		int[] b = new int[a.length];

		int c = 0;
		int i = frm, j = mid + 1, h = frm;
		while (i <= mid && j <= end) {
			if (a[i] <= a[j]) b[h++] = a[i++];
			else {
				c += find(a, i, mid, 2 * a[j]);
				b[h++] = a[j++];
			}
		}
		if (i <= mid) System.arraycopy(a, i, b, h, mid - i + 1);
		if (j <= end) System.arraycopy(a, j, b, h, end - j + 1);
		System.arraycopy(b, frm, a, frm, end - frm + 1);
		return c;
	}

	private int find(int[] a, int frm, int end, int value) {
		int right = end;
		while (frm <= end) {
			int mid = frm + ((end - frm) >>> 1);
			if (value >= a[mid]) frm = mid + 1;
			else end = mid - 1;
		}
		return right - frm + 1;
	}

	public static void main(String[] args) {
		ReversePairs rp = new ReversePairs();
		System.out.println(rp.reversePairs(new int[] { 2, 4, 3, 5, 1 }));
	}
}
