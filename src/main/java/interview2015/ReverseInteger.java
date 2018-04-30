package interview2015;

import java.util.Arrays;
import java.util.LinkedList;

public class ReverseInteger {
	public static void main(String[] args) {
		System.out.println(String.join("--", Arrays.asList("1", "2", "d")));
		System.out.println(String.join("--", new String[] { "fs", "fsf", "fsf" }));
		System.out.println(String.join("__", Arrays.asList(new String[] { "fs", "fsf", "fsf" })));
		ReverseInteger ri = new ReverseInteger();
		System.out.println(ri.reverse2(-123));
	}

	public int reverse(int x) {
		boolean negative = x < 0;
		StringBuilder sb = new StringBuilder().append(x);
		if (negative) sb = new StringBuilder(sb.append("-").substring(1));
		Integer res = null;
		try {
			res = Integer.parseInt(sb.reverse().toString());
		} catch (NumberFormatException e) {}
		return res == null ? 0 : res;
	}

	// long
	public int reverse2(int x) {
		boolean negative = x < 0;
		LinkedList<Integer> queue = new LinkedList<Integer>();
		while (x != 0) {
			queue.offer(x % 10);
			x /= 10;
		}
		Integer front = null;
		int res = 0;
		while ((front = queue.poll()) != null) {
			if (negative) {
				if ((Integer.MIN_VALUE - front) / 10 > res) return 0;
				res = res * 10 + front;
			} else {
				if ((Integer.MAX_VALUE - front) / 10 < res) return 0;
				res = res * 10 + front;
			}
		}
		return res;
	}

}
