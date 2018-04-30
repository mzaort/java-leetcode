package googleCode;

public class RemoveElement {

	public static void main(String[] args) {
		int[] A = { 2, 3, 3 };
		RemoveElement re = new RemoveElement();
		int cur = re.removeElement2(A, 2);
		System.out.println(cur);
	}

	public int removeElement(int[] A, int elem) {
		int cur = 0;
		for (int i = 0; i < A.length; i++) {
			if (A[i] != elem) {
				// A[cur++] = A[i];
				if (i != cur) A[cur] = A[i];
				cur++;
			}
		}
		return cur;
	}

	// judge length = 0, 1, 2, ..., n
	public int removeElement2(int[] A, int elem) {
		if (A.length == 0) return 0;
		int left = 0, right = A.length - 1;

		while (left < right) {
			while (left < right && A[left] != elem)
				left++;
			while (left < right && A[right] == elem)
				right--;
			if (left < right) {
				A[left++] = A[right--];
			} else if (left == right) { return A[left] != elem ? left + 1 : left; }
		}

		if (left == right) return A[left] != elem ? left + 1 : left;
		else return left;
	}

	public int removeElement3(int[] A, int elem) {
		int left = 0, right = A.length - 1;
		while (true) {
			while (left < right && A[left] != elem)
				left++;
			while (left < right && A[right] == elem)
				right--;
			if (left < right) {
				A[left++] = A[right--];
			} else if (left == right) {
				return A[left] != elem ? left + 1 : left;
			} else {
				return left;
			}
		}
	}
}
