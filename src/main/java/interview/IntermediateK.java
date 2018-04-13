package interview;

import java.util.*;

;

public class IntermediateK {

	public static void main(String[] args) {
		int len = 100;
		int[] A = new int[len];
		for (int i = 0; i < len; i++) {
			A[i] = (int) (10000 * Math.random());
		}
		int[] B = A.clone();

		IntermediateK ik = new IntermediateK();

		// for(int i = 0; i < len; i++){
		// if(ik.kth(A, i) != ik.kth2(B, i)){
		// System.out.println("false");
		// }
		// }

		int frm = 23, end = 89;
		ik.intermediate(A, frm, end);
		ik.intermediate2(B, frm, end);
		Arrays.sort(A, frm, end + 1);
		Arrays.sort(B, frm, end + 1);
		for (int i = frm; i <= end; i++) {
			if (A[i] != B[i]) {
				System.out.println("false");
			}
		}
	}

	public int kth2(int[] A, int k) {
		assert (k >= 0 && k < A.length);
		Arrays.sort(A);
		return A[k];
	}

	public int kth(int[] A, int k) {
		assert (k >= 0 && k < A.length);
		return kth(A, k, 0, A.length - 1);
	}

	private int kth(int[] A, int k, int left, int right) {
		int pivot = 0;
		while (left <= right) {
			pivot = partition(A, left, right);
			if (pivot == k) {
				break;
			} else if (pivot < k) {
				left = pivot + 1;
			} else {
				right = pivot - 1;
			}
		}
		return A[pivot];
	}

	public void intermediate2(int[] A, int f, int e) {
		assert (f >= 0 && f <= e && e < A.length);
		Arrays.sort(A);
	}

	public void intermediate(int[] A, int f, int e) {
		assert (f >= 0 && f <= e && e < A.length);
		kth(A, f, 0, A.length - 1);
		kth(A, e, f, A.length - 1);
	}

	public int partition(int[] A, int start, int end) {
		int j = start - 1;
		for (int i = start; i < end; i++) {
			if (A[i] <= A[end]) {
				swap(A, ++j, i);
			}
		}
		swap(A, ++j, end);
		return j;
	}

	public void swap(int[] A, int i, int j) {
		int tmp = A[i];
		A[i] = A[j];
		A[j] = tmp;
	}
}