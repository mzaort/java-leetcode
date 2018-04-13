package solutionReview2;

public class SortColors {
	public void sortColors(int[] A) {
		int len = A.length;
		if (len <= 1)
			return;
		int i = -1, j = -1;
		for (int k = 0; k < len; k++) {
			int tmp = A[k];
			switch (tmp) {
			case 0:
				A[k] = A[++j];
				A[j] = A[++i];
				A[i] = tmp;
				break;
			case 1:
				A[k] = A[++j];
				A[j] = tmp;
				break;
			case 2:
				break;
			default:System.exit(0);
			}
		}
	}
}