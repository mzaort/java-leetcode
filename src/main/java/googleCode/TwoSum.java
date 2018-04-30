package googleCode;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
	public int[] twoSum(int[] numbers, int target) {
		int[] res = { -1, -1 };
		for (int i = 0; i < numbers.length - 1; i++) {
			for (int j = i + 1; j < numbers.length; j++) {
				if (numbers[i] + numbers[j] == target) {
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
		for (int i = 0; i < numbers.length - 1; i++) {
			int wanted = target - numbers[i];
			int j = i + 1;
			for (; j < numbers.length && numbers[j] != wanted; j++);
			if (j < numbers.length) {
				res[0] = i + 1;
				res[1] = j + 1;
				return res;
			}
		}
		return res;
	}

	public int[] twoSum3(int[] numbers, int target) {
		class Support implements Comparable<Support> {
			int value;
			int index;

			public Support(int value, int index) {
				this.value = value;
				this.index = index;
			}

			public int compareTo(Support o) {
				if (value == o.value) return 0;
				return value > o.value ? 1 : -1;
			}
		}

		Support[] sup = new Support[numbers.length];
		for (int i = 0; i < numbers.length; i++) {
			sup[i] = new Support(numbers[i], i + 1);
		}
		Arrays.sort(sup);

		int[] res = { -1, -1 };

		for (int i = 0, j = numbers.length - 1; i < j;) {
			int value = sup[i].value + sup[j].value;
			if (target == value) {
				if (sup[i].index < sup[j].index) {
					res[0] = sup[i].index;
					res[1] = sup[j].index;
				} else {
					res[0] = sup[j].index;
					res[1] = sup[i].index;
				}
				return res;
			} else if (target < value) {
				j--;
			} else {
				i++;
			}
		}

		return res;
	}

	// wrong solution
	// wrong reason: when target is even and exist target = 2 * numbers[i];
	// wrong example: [3, 2, 4], 6
	// �����������ʱ�ж�����λ���Ƿ����
	public int[] twoSum4(int[] numbers, int target) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < numbers.length; i++) {
			map.put(numbers[i], i + 1);
		}

		int[] res = { -1, -1 };
		for (int i = 0; i < numbers.length - 1; i++) {
			Integer j = null;
			if ((j = map.get(target - numbers[i])) != null) {
				res[0] = i + 1;
				res[1] = j;
				return res;
			}
		}
		return res;
	}

	public int[] twoSum5(int[] numbers, int target) {
		int[] res = { -1, -1 };
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < numbers.length; i++) {
			Integer j = null;
			if ((j = map.get(target - numbers[i])) != null) {
				res[0] = j + 1;
				res[1] = i + 1;
				return res;
			}
			map.put(numbers[i], i);
		}
		return res;
	}
}
