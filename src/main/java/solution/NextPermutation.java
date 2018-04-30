package solution;

import java.util.Arrays;

public class NextPermutation {
	public static void main(String[] args) {
		NextPermutation np = new NextPermutation();
		np.nextPermutation(new int[] { 1, 1 });
	}

	public void nextPermutation(int[] num) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int len = num.length;
		if (len != 0) {
			int dest = len - 2;
			for (; dest >= 0 && num[dest] >= num[dest + 1]; dest--);
			if (dest == -1) {
				Arrays.sort(num);
			} else {
				Arrays.sort(num, dest + 1, len);
				int i;
				for (i = dest + 1; i < len && num[i] <= num[dest]; i++);
				swap(num, dest, i);
			}
		}
	}

	private void swap(int[] index, int dest, int src) {
		int tmp = index[dest];
		index[dest] = index[src];
		index[src] = tmp;
	}
}
