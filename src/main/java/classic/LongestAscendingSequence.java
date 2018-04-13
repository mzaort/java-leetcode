package classic;

public class LongestAscendingSequence {

	public static void main(String[] args) {
		int[] A = new int[] { 1, 9, 3, 8, 11, 4, 5, 6, 4, 1, 9, 7, 1, 7 };
		LongestAscendingSequence las = new LongestAscendingSequence();
		System.out.println(las.longestSequenceLength(A));
		int[] res = las.longestSequence(A);
		for (int e : res) {
			System.out.print(e);
		}
		System.out.println();

		int[] B = { 2, 1, 5, 3, 6, 4, 8, 9, 7 };
		System.out.println(las.longestSequenceLength2(B));
		System.out.println(las.longestSequenceLength2(A));
	}

	public int longestSequenceLength(int[] A) {
		int len = A.length;
		if (len <= 1)
			return len;

		int[] res = new int[len];
		res[0] = 1;

		for (int i = 1; i < len; i++) {
			int max = 0;
			for (int j = i - 1; j >= max; j--) {
				if (A[j] < A[i]) {
					if (res[j] > max) {
						max = res[j];
					}
				}
			}
			res[i] = max + 1;
		}

		int maxRes = res[len - 1];
		for (int i = len - 2; i >= 0; i--) {
			if (res[i] > maxRes) {
				maxRes = res[i];
			}
		}

		return maxRes;
	}

	public int longestSequenceLength2(int[] A) {
		int len = A.length;
		if (len <= 1)
			return len;

		int[] B = new int[len];
		B[0] = A[0];
		int bcur = 0;

		for (int i = 1; i < len; i++) {
			int loc = binarySearch(B, 0, bcur, A[i]);
			if (loc == bcur + 1) {
				B[++bcur] = A[i];
			} else {
				if (B[loc] > A[i]) {
					B[loc] = A[i];
				}
			}
		}

		return bcur + 1;
	}

	private int binarySearch(int[] b, int frm, int end, int target) {
		while (frm <= end) {
			int mid = frm + ((end - frm) >> 1);
			if (b[mid] < target) {
				frm = mid + 1;
			} else if (b[mid] == target) {
				return mid;
			} else {
				end = mid - 1;
			}
		}
		return frm;
	}

	public int[] longestSequence(int[] A) {
		int len = A.length;
		if (len <= 1)
			return A.clone();

		int[] seq = new int[len];
		int[] before = new int[len];
		seq[0] = 1;
		before[0] = -1;

		for (int i = 1; i < len; i++) {
			seq[i] = 0;
			before[i] = -1;
			for (int j = i - 1; j >= seq[i]; j--) {
				if (A[j] < A[i]) {
					if (seq[j] > seq[i]) {
						seq[i] = seq[j];
						before[i] = j;
					}
				}
			}
			seq[i]++;
		}

		int max = len - 1;
		for (int i = len - 2; i >= 0; i--) {
			if (seq[i] > seq[max]) {
				max = i;
			}
		}

		int len2 = seq[max];
		int[] res = new int[len2];
		int cur = len2 - 1;
		while (cur >= 0) {
			res[cur] = A[max];
			max = before[max];
			cur--;
		}
		return res;
	}

}
