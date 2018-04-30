package googleCodeSupport;

import java.util.Arrays;

public class IntermediateK {

	public static void main(String[] args) {
		int length = 100, k = 54;
		IntermediateK ik = new IntermediateK();
		int[] A = new int[length];
		for (int i = 0; i < length; i++) {
			A[i] = (int) (Math.random() * 100);
		}
		int[] B = A.clone();
		int[] C = A.clone();

		Arrays.sort(A);
		ik.kth(B, k);
		ik.kth2(C, k);

		if (A[k] == B[k] && A[k] == C[k]) {
			System.out.println("right");
		} else {
			System.out.println("wrong");
		}
	}

	public int kth(int[] A, int k) {
		assert (k >= 0 && k < A.length);
		return kth(A, 0, A.length - 1, k);
	}

	public int kth3(int[] A, int k) {
		assert (k >= 0 && k < A.length);
		int p = 0, q = A.length - 1;
		while (p <= q) {
			int r = partition(A, p, q);
			if (r == k) break;
			else if (r < k) p = r + 1;
			else q = r - 1;
		}
		return k;
	}

	private int kth(int[] A, int frm, int end, int k) {
		int p = partition(A, frm, end);
		if (p == k) return A[k];
		else if (p < k) return kth(A, p + 1, end, k);
		else return kth(A, frm, p - 1, k);
	}

	private int partition(int[] A, int frm, int end) {
		int j = frm - 1;
		int pivot = A[end];
		for (int i = frm; i < end; i++) {
			if (A[i] <= pivot) {
				swap(A, ++j, i);
			}
		}
		swap(A, ++j, end);
		return j;
	}

	public int kth2(int[] A, int k) {
		assert (k >= 0 && k < A.length);
		return kth2(A, 0, A.length - 1, k);
	}

	public void kth2(int[] A, int start, int end) {
		assert (start >= 0 && start <= end && end < A.length);
		kth2(A, 0, A.length - 1, start);
		kth2(A, start, A.length - 1, end);
	}

	private int kth2(int[] A, int frm, int end, int k) {
		while (frm <= end) {
			int p = partition2(A, frm, end);
			if (p == k) break;
			else if (p < k) frm = p + 1;
			else end = p - 1;
		}
		return A[k];
	}

	private int partition2(int[] A, int frm, int end) {
		int j = frm - 1;
		for (int i = frm; i <= end; i++) {
			if (A[i] <= A[end]) {
				swap(A, ++j, i);
			}
		}
		return j;
	}

	private void swap(int[] A, int i, int j) {
		int tmp = A[i];
		A[i] = A[j];
		A[j] = tmp;
	}
}
