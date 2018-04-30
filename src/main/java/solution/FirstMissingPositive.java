package solution;

public class FirstMissingPositive {
	public int firstMissingPositive(int[] A) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (A.length == 0) return 1;
		int len = A.length;
		for (int i = 0; i < len; i++) {
			int tmp = A[i];
			if (tmp >= 1 && tmp <= len && tmp != i + 1 && A[tmp - 1] != tmp) {
				int swap = tmp;
				A[i] = A[tmp - 1];
				A[tmp - 1] = swap;
				i--;
			}
		}
		for (int i = 0; i < len; i++) {
			if (A[i] != i + 1) { return i + 1; }
		}
		return len + 1;
	}
}
