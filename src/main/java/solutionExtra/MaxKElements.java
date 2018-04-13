package solutionExtra;

public class MaxKElements {

	public int[] findMaxKElements(int[] A, int k) {
		int len = A.length;
		if (k <= 0 || k > len)
			return new int[0];

		int[] res = new int[k];

		buildMaxHeap(A, len);
		for (int i = 0; i < k; i++) {
			res[i] = A[0];
			removeTop(A, len - i);
		}
		return res;
	}

	private void removeTop(int[] a, int len) {
		// TODO Auto-generated method stub
	}

	private void buildMaxHeap(int[] a, int len) {
		
	}
}
