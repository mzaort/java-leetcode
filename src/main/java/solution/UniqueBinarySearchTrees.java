package solution;

public class UniqueBinarySearchTrees {
	public int numTrees(int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (n <= 1) return 1;
		int[] num = new int[n + 1];
		num[0] = num[1] = 1;

		for (int i = 2; i < n + 1; i++) {
			int tmp = 0;
			for (int j = 0; j < i; j++) {
				tmp += num[j] * num[i - 1 - j];
			}
			num[i] = tmp;
		}
		return num[n];
	}
}
