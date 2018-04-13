package solution;

public class SortColors {
	public static void main(String[] args) {
		int[] A = { 2, 2 };
		new SortColors().sortColors3(A);
		for (int a : A) {
			System.out.println(a);
		}
	}

	public void sortColors(int[] A) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int red = 0, white = 0, blue = 0;
		for (int e : A) {
			switch (e) {
			case 0:
				red++;
				break;
			case 1:
				white++;
				break;
			case 2:
				blue++;
				break;
			default:
				return;
			}
		}
		int cur = 0;
		for (int i = 0; i < red; i++) {
			A[cur++] = 0;
		}
		for (int i = 0; i < white; i++) {
			A[cur++] = 1;
		}
		for (int i = 0; i < blue; i++) {
			A[cur++] = 2;
		}
	}

	public void sortColors2(int[] A) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (A == null || A.length == 0)
			return;
		int left = 0, right = A.length - 1, cur = 0;

		while (cur <= right) {
			if (A[cur] == 0) {
				swap(A, left++, cur);
				cur++;
			} else if (A[cur] == 2) {
				swap(A, right--, cur);
			} else {
				cur++;
			}
		}
	}

	public void sortColors3(int[] A) {
		int l = 0, r = A.length - 1, i = 0;
		while (i <= r) {
			if (A[i] == 0) {
				swap(A, i, l);
				l++;
				i++;
			} else if (A[i] == 2) {
				swap(A, i, r);
				r--;
			} else {
				i++;
			}
		}
	}

	private void swap(int[] a, int i, int cur) {
		int tmp = a[i];
		a[i] = a[cur];
		a[cur] = tmp;
	}

}
