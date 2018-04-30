package JaneStreet;

import java.util.HashMap;

public class TwoSum {

	public int[] twoSum(int[] numbers, int target) {
		int[] res = { -1, -1 };
		for (int i = 0; i < numbers.length - 1; i++) {
			int wanted = target - numbers[i];
			for (int j = i + 1; j < numbers.length; j++) {
				if (numbers[j] == wanted) {
					res[0] = i + 1;
					res[1] = j + 1;
					return res;
				}
			}
		}
		return res;
	}

	public int[] twoSum2(int[] numbers, int target) {
		int[] res = { -1, -1 };
		int[] index = indexSort(numbers);
		for (int i = 0, j = numbers.length - 1; i < j;) {
			int total = numbers[i] + numbers[j];
			if (total == target) {
				if (index[i] < index[j]) {
					res[0] = index[i];
					res[1] = index[j];
				} else {
					res[0] = index[j];
					res[1] = index[i];
				}
				break;
			} else if (total < target) {
				i++;
			} else {
				j--;
			}
		}
		return res;
	}

	private int[] indexSort(int[] numbers) {
		int[] res = new int[numbers.length];
		for (int i = 0; i < res.length; i++) {
			res[i] = i + 1;
		}
		indexFastSort(numbers, res, 0, numbers.length - 1);
		return res;
	}

	private void indexFastSort(int[] numbers, int[] index, int frm, int end) {
		if (frm < end) {
			int pivot = indexPartition(numbers, index, frm, end);
			indexFastSort(numbers, index, frm, pivot - 1);
			indexFastSort(numbers, index, pivot + 1, end);
		}
	}

	private int indexPartition(int[] numbers, int[] index, int frm, int end) {
		int low = frm, high = end;
		int key = numbers[frm], ikey = index[frm];
		while (low < high) {
			while (low < high && numbers[high] >= key)
				high--;
			numbers[low] = numbers[high];
			index[low] = index[high];
			while (low < high && numbers[low] <= key)
				low++;
			numbers[high] = numbers[low];
			index[high] = index[low];
		}
		numbers[low] = key;
		index[low] = ikey;
		return low;
	}

	private int indexPartition2(int[] numbers, int[] index, int frm, int end) {
		int pivot = numbers[end];
		int p = frm - 1;
		for (int i = frm; i <= end; i++) {
			if (numbers[i] <= pivot) {
				swap(numbers, index, ++p, i);
			}
		}
		return p;
	}

	private void swap(int[] numbers, int[] index, int i, int j) {
		int tmp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = tmp;
		tmp = index[i];
		index[i] = index[j];
		index[j] = tmp;
	}

	public int[] twoSum3(int[] numbers, int target) {
		int[] res = { -1, -1 };
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < numbers.length; i++) {
			if (map.containsKey(target - numbers[i])) {
				res[0] = map.get(target - numbers[i]) + 1;
				res[1] = i + 1;
				break;
			}
			if (!map.containsKey(numbers[i])) map.put(numbers[i], i);
		}
		return res;
	}
}
