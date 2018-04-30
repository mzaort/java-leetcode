package microsoft;

import java.util.*;

public class MinInteger {

	public static void main(String[] args) {
		MinInteger min = new MinInteger();
		System.out.println(min.min(new int[] { 1, 2, 0, 3 }, 2336));
	}

	public ArrayList<Integer> min(int[] arr, int k) {
		assert (k > 0);
		int len = arr.length;
		if (len == 0) return null;

		Arrays.sort(arr);
		int notZero = 0;
		for (; notZero < len && arr[notZero] == 0; notZero++);
		if (notZero == len) return null;

		ArrayList<Integer> num = new ArrayList<Integer>();
		while (k != 0) {
			num.add(k % 10);
			k = k / 10;
		}
		int numLen = num.size();
		int[] index = new int[numLen];

		int i = numLen - 1, j = -1;
		for (; i >= 0; i--) {
			index[i] = binarySearch(arr, num.get(i));
			if (index[i] == len) {
				break;
			} else if (arr[index[i]] > num.get(i)) {
				j = i;
				break;
			}
		}

		if (j != -1) {
			num.set(j, arr[index[j]]);
			for (int h = 0; h < j; h++) {
				num.set(h, arr[0]);
			}
			return num;
		}

		if (i < 0) {
			int h = 0;
			for (; h < numLen && index[h] == len - 1; h++);
			if (h == numLen) {
				for (int t = 0; t < numLen; t++) {
					num.set(t, arr[0]);
				}
				num.add(arr[notZero]);
				return num;
			} else {
				for (int t = 0; t < h; t++) {
					num.set(t, arr[0]);
				}
				num.set(h, arr[index[h] + 1]);
				return num;
			}
		} else if (i == numLen - 1) {
			for (int t = 0; t < numLen; t++) {
				num.set(t, arr[0]);
			}
			num.add(arr[notZero]);
			return num;
		} else {
			for (int t = 0; t <= i; t++) {
				num.set(t, arr[0]);
			}
			int h = i + 1;
			for (; h < numLen && index[h] == len - 1; h++);
			if (h == numLen) {
				for (int t = i + 1; t < numLen; t++) {
					num.set(t, arr[0]);
				}
				num.add(arr[notZero]);
				return num;
			} else {
				for (int t = i + 1; t < h; t++) {
					num.set(t, arr[0]);
				}
				num.set(h, arr[index[h] + 1]);
				return num;
			}
		}
	}

	private int binarySearch(int[] arr, int target) {
		int left = 0, right = arr.length - 1;
		while (left <= right) {
			int mid = left + ((right - left) >> 1);
			if (arr[mid] == target) {
				return mid;
			} else if (arr[mid] > target) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return left;
	}
}