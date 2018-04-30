package googleCode;

public class SortColors {
	public static void main(String[] args) {
		SortColors sc = new SortColors();
		int[] A = new int[] { 1, 2 };
		sc.sortColors3(A);
		for (int i = 0; i < A.length; i++)
			System.out.println(A[i]);
	}

	public void sortColors(int[] A) {
		final int cnt = 3;
		int[] num = new int[cnt];
		for (int i = 0; i < A.length; i++)
			num[A[i]]++;
		for (int i = 1; i < cnt; i++)
			num[i] += num[i - 1];

		int[] B = new int[A.length];
		for (int i = A.length - 1; i >= 0; i--) {
			B[--num[A[i]]] = A[i];
		}
		System.arraycopy(B, 0, A, 0, A.length);
	}

	public void sortColors2(int[] A) {
		int j = -1, k = -1;
		for (int i = 0; i < A.length; i++) {
			if (A[i] == 0) {
				swap(A, ++j, i);
				swap(A, ++k, j);
			} else if (A[i] == 1) {
				swap(A, ++j, i);
			}
		}
	}

	private void swap(int[] A, int i, int j) {
		int tmp = A[i];
		A[i] = A[j];
		A[j] = tmp;
	}

	public void sortColors3(int[] A) {
		int i0 = -1, i2 = A.length;
		for (int i = 0; i < i2; i++) {
			if (A[i] == 0) {
				swap(A, ++i0, i);
			} else if (A[i] == 2) {
				swap(A, --i2, i--);
			}
		}
	}

}
