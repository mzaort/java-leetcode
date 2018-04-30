package interview2016;

import java.math.BigInteger;

public class DeleteKDigitsForMaxNumber {

	public static void main(String[] args) {
		DeleteKDigitsForMaxNumber dkdfmn = new DeleteKDigitsForMaxNumber();
		System.out.println(dkdfmn.deleteKDigits(new int[] { 1, 5, 0, 2, 9, 3 }, 3));
		System.out.println(dkdfmn.deleteKDigits2(new int[] { 1, 5, 0, 2, 9, 3 }, 3));
		System.out.println(dkdfmn.deleteKDigits3(new int[] { 1, 5, 0, 2, 9, 3 }, 3));
	}

	public BigInteger deleteKDigits3(int[] A, int k) {
		assert (A.length > k && k > 0);
		boolean[] deleted = new boolean[A.length];
		for (; k > 0; k--) {
			int i = find(deleted, 0);
			for (int next = find(deleted, i + 1); next < A.length
					&& A[i] >= A[next]; i = next, next = find(deleted, i + 1));
			deleted[i] = true;
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < A.length; i++) {
			if (!deleted[i]) sb.append(A[i]);
		}
		return new BigInteger(sb.toString());
	}

	public BigInteger deleteKDigits2(int[] A, int k) {
		assert (A.length > k && k > 0);
		boolean[] deleted = new boolean[A.length];
		for (; k > 0; k--) {
			int i = find(deleted, 0);
			for (int next = find(deleted, i + 1); next < A.length
					&& A[i] >= A[next]; i = next, next = find(deleted, i + 1));
			deleted[i] = true;
		}

		BigInteger sum = BigInteger.ZERO;
		BigInteger base = BigInteger.ONE;
		for (int i = deleted.length - 1; i >= 0; i--) {
			if (!deleted[i]) {
				sum = sum.add(base.multiply(BigInteger.valueOf(A[i])));
				base = base.multiply(BigInteger.TEN);
			}
		}
		return sum;
	}

	private int find(boolean[] deleted, int i) {
		int cur = i;
		for (; cur < deleted.length && deleted[cur]; cur++);
		return cur;
	}

	public BigInteger deleteKDigits(int[] A, int k) {
		assert (A.length > k && k > 0);
		return deleteKDigits(A, new boolean[A.length], k);
	}

	private BigInteger deleteKDigits(int[] A, boolean[] deleted, int k) {
		if (k == 0) {
			BigInteger sum = BigInteger.ZERO;
			BigInteger base = BigInteger.ONE;
			for (int i = deleted.length - 1; i >= 0; i--) {
				if (!deleted[i]) {
					sum = sum.add(base.multiply(BigInteger.valueOf(A[i])));
					base = base.multiply(BigInteger.TEN);
				}
			}
			return sum;
		} else {
			BigInteger max = BigInteger.ZERO;
			for (int i = 0; i < deleted.length; i++) {
				if (!deleted[i]) {
					deleted[i] = true;
					BigInteger cur = deleteKDigits(A, deleted, k - 1);
					deleted[i] = false;
					if (max.compareTo(cur) < 0) max = cur;
				}
			}
			return max;
		}
	}

}
