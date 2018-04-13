package solutionExtra;

public class KthSmallestElement2 {

	public static void main(String[] args) {
		KthSmallestElement2 kse = new KthSmallestElement2();
		int[] C = { 4, 5, 2, 7, 9, 2, 1, 34 };
		System.out.println(kse.findKthSmallestElement(C, 7));
		System.out.println(kse.kthSmallest2(C, 7));
	}

	
	public int findKthSmallestElement(int[] A, int k) {
		int len = A.length;
		if(k < 1 && k > len) return -2;
		
		return findKthSmallestElement(A, 0, len - 1, k);
	}

	// A is not in order;
	public int findKthSmallestElement(int[] A, int frm, int end, int k) {
		if (k == 1) {
			return A[frm];
		} else {
			int p = partition(A, frm, end);
			int want = frm + k - 1;
			if (p == want) {
				return A[want];
			} else if (p < want) {
				return findKthSmallestElement(A, p + 1, end, want - p);
			} else {
				return findKthSmallestElement(A, frm, p - 1, k);
			}
		}
	}

	private int partition(int[] a, int frm, int end) {
		int i = frm - 1;
		for (int j = frm; j < end; j++) {
			if (a[j] <= a[end]) {
				swap(a, ++i, j);
			}
		}
		swap(a, ++i, end);
		return i;
	}

	private void swap(int[] a, int i, int j) {
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}
	
	public int kthSmallest2(int[] A, int k){
		assert(k > 0 && k < A.length);
		int frm = 0, end = A.length - 1;
		while(frm <= end){
			int p = partition(A, frm, end);
			if(p == k - 1){
				return A[k - 1];
			}else if(p < k){
				frm = p + 1;
			}else{
				end = p - 1;
			}
		}
		return -1;
	}

}
