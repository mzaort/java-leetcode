package googleCode;

public class RemoveDuplicatesfromSortedArrayII {
	public int removeDuplicates(int[] A) {
		if (A.length <= 2) return A.length;

		int top = 0, cnt = 1;
		for (int i = 1; i < A.length; i++) {
			if (A[i] == A[top]) {
				if (cnt == 1) {
					A[++top] = A[i];
					cnt++;
				}
			} else {
				A[++top] = A[i];
				cnt = 1;
			}
		}
		return top + 1;
	}
}
