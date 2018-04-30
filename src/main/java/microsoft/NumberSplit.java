package microsoft;

import java.util.ArrayList;

public class NumberSplit {

	public static void main(String[] args) {
		NumberSplit ns = new NumberSplit();
		System.out.println(ns.numOfSplit(9));
	}

	public int numOfSplit(int num) {
		if (num < 2) return 0;
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 2; i <= num; i++) {
			if (isOrd(i)) {
				list.add(i);
			}
		}
		return numOfSplit(num, list.toArray(new Integer[0]), list.size() - 1);
	}

	private boolean isOrd(int num) {
		assert (num >= 2);
		int res = 1;
		for (int i = 2; i <= num; i++) {
			if (num % i == 0) {
				int cnt = 0;
				while (num % i == 0) {
					cnt++;
					num /= i;
				}
				res *= (cnt + 1);
			}
		}
		return res == 2;
	}

	public int numOfSplit(int num, Integer[] arr, int cur) {
		if (num == 0) return 1;
		if (cur == 0) return num % 2 == 0 ? 1 : 0;

		int res = numOfSplit(num, arr, cur - 1);
		for (int i = 1; i * arr[cur] <= num; i++) {
			res += numOfSplit(num - i * arr[cur], arr, cur - 1);
		}
		return res;
	}
}