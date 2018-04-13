package solutionExtra;

public class KthSmallestElement {

	public static void main(String[] args) {
		KthSmallestElement kse = new KthSmallestElement();
		int[] A = { 1, 1, 1, 8 };
		int[] B = { 9, 18 };
		System.out.println(kse.findKthSmallestElement2(A, 0, A.length, B, 0,
				B.length, 5));
	}

	// k = 1, 2, 3...
	public int findKthSmallestElement(int[] A, int[] B, int k) {
		assert k < 0;
		if (k > A.length + B.length || k <= 0)
			return -1;
		if (A.length == 0) {
			if (B.length == 0) {
				return -1;
			} else {
				return B[k - 1];
			}
		} else {
			if (B.length == 0) {
				return A[k - 1];
			} else {
				int acur = 0, bcur = 0;
				int alen = A.length, blen = B.length;

				while (k > 1) {
					if (acur < alen) {
						if (bcur < blen) {
							if (A[acur] < B[bcur]) {
								acur++;
								k--;
							} else {
								bcur++;
								k--;
							}
						} else {
							return A[acur + k - 1];
						}
					} else {
						if (bcur < blen) {
							return B[bcur + k - 1];
						} else {

						}
					}
				}

				if (acur < alen) {
					if (bcur < blen) {
						return A[acur] < B[bcur] ? A[acur] : B[bcur];
					} else {
						return A[acur];
					}
				} else {
					if (bcur < blen) {
						return B[bcur];
					} else {
						return -1;
					}
				}
			}
		}
	}

	public int findKthSmallestElement2(int[] A, int afrm, int alen, int[] B,
			int bfrm, int blen, int k) {
		int i = afrm + (int) ((double) alen / (alen + blen) * (k - 1));
		int j = (k - 1) + afrm + bfrm - i;

		// invariant: i + j = k-1
		// Note: A[-1] = -INF and A[m] = +INF to maintain invariant

		int Ai_1 = ((i == 0) ? Integer.MIN_VALUE : A[i - 1]);
		int Bj_1 = ((j == 0) ? Integer.MIN_VALUE : B[j - 1]);
		int Ai = ((i == alen) ? Integer.MAX_VALUE : A[i]);
		int Bj = ((j == blen) ? Integer.MAX_VALUE : B[j]);

		if (Bj_1 <= Ai && Ai <= Bj)
			return Ai;
		else if (Ai_1 <= Bj && Bj <= Ai)
			return Bj;

		// if none of the cases above, then it is either:
		if (Ai < Bj)
			// exclude Ai and below portion
			// exclude Bj and above portion
			return findKthSmallestElement2(A, i + 1, alen - i - 1, B, bfrm, j,
					k - i - 1);
		else
			/* Bj < Ai */
			// exclude Ai and above portion
			// exclude Bj and below portion
			return findKthSmallestElement2(A, afrm, i, B, j + 1, blen - j - 1,
					k - j - 1);
	}

}
