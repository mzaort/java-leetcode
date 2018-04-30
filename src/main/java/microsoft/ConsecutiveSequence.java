package microsoft;

import java.util.ArrayList;

public class ConsecutiveSequence {

	public static void main(String[] args) {
		ConsecutiveSequence cs = new ConsecutiveSequence();
		System.out.println(cs.numOfSequence2(3));
		System.out.println(cs.FindContinuesSequence(3));
		cs.FindContinuesSequence(15);
		for (int i = 3; i < 100; i++) {
			System.out.println(cs.numOfSequence(i) + " " + cs.FindContinuesSequence2(i) + " "
					+ (cs.numOfSequence(i) == cs.FindContinuesSequence2(i)));
		}
	}

	public int numOfSequence(int n) {
		assert (n > 0);
		int res = 0;
		for (int i = 2; i < Math.sqrt(2 * n); i++) {
			if ((i & 1) == 0) {
				if (n % (i / 2) == 0) {
					int tmp = n / (i / 2);
					if ((tmp & 1) == 1) res++;
				}
			} else {
				if (n % i == 0) res++;
			}
		}
		return res;
	}

	// wrong when it is 3
	public int FindContinuesSequence(int n) {
		int small = 1;
		int big = 2;
		int middle = (1 + n) / 2;
		int sum = small + big;
		int res = 0;
		while (small < middle) {
			// sum==n��ֱ���������
			if (sum == n) res++;
			// sum>n��small�����ƣ�ֱ��sum<=n
			while (sum > n) {
				sum -= small;
				small++;
				if (sum == n) res++;
			}
			// sum<n��big������
			big++;
			sum += big;
		}
		return res;
	}

	public int FindContinuesSequence2(int n) {
		assert (n > 0);
		int ans = 0;
		int left = 1, right = 2, limit = (n + 1) / 2;
		int sum = left + right;
		while (left < limit) {
			while (sum > n) {
				sum -= left;
				left++;
			}
			if (sum == n) {
				ans++;
				sum -= left;
				left++;
			}
			right++;
			sum += right;
		}
		return ans;
	}

	public void PrintSequence(int small, int big) {
		for (int i = small; i <= big; i++) {
			System.out.print(i + "-");
		}
		System.out.println();
	}

	public ArrayList<ArrayList<Integer>> numOfSequence2(int n) {
		assert (n > 0);
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		for (int i = 2; i < Math.sqrt(2 * n); i++) {
			if ((i & 1) == 0) {
				if (n % (i / 2) == 0) {
					int tmp = n / (i / 2);
					if ((tmp & 1) == 1) {
						ArrayList<Integer> list = new ArrayList<Integer>();
						list.add(tmp / 2 - i / 2 + 1);
						list.add(tmp / 2 + i / 2);
						res.add(list);
					}
				}
			} else {
				if (n % i == 0) {
					ArrayList<Integer> list = new ArrayList<Integer>();
					list.add(n / i - i / 2);
					list.add(n / i + i / 2);
					res.add(list);
				}
			}
		}
		return res;
	}
}