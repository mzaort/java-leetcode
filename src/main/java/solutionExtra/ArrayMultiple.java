package solutionExtra;

public class ArrayMultiple {
	public int[] multipleOthers(int[] num) {
		int len = num.length;
		if (len == 0) return new int[0];

		int zeroCnt = 0, all = 1;
		for (int i = 0; i < len; i++) {
			if (num[i] == 0) {
				zeroCnt++;
			} else {
				all *= num[i];
			}
		}

		int[] res = new int[len];
		if (zeroCnt == 2) {
			for (int i = 0; i < len; i++) {
				res[i] = 0;
			}
		} else if (zeroCnt == 1) {
			for (int i = 0; i < len; i++) {
				if (num[i] == 0) {
					res[i] = all;
				} else {
					res[i] = 0;
				}
			}
		} else {
			for (int i = 0; i < len; i++) {
				res[i] = all / num[i];
			}
		}
		return res;
	}
}
