package solution;

import java.util.ArrayList;

public class GrayCode {
	public static void main(String[] args) {
		GrayCode gc = new GrayCode();
		System.out.println(gc.nthGrayCode(2));
	}

	public ArrayList<Integer> grayCode(int n) {
		ArrayList<Integer> res = new ArrayList<Integer>((1 << n));
		if (n == 0) {
			res.add(0);
			return res;
		} else {
			ArrayList<Integer> tmp = grayCode(n - 1);
			res.addAll(tmp);
			int high = 1 << (n - 1);
			for (int i = tmp.size() - 1; i >= 0; i--) {
				res.add(tmp.get(i) + high);
			}
			return res;
		}
	}

	public int nthGrayCode(int n) {
		int res = 0;
		for (int i = 0; n >= (1 << i); i++) {
			int cycle = 1 << (2 + i);
			int left = cycle >> 2, right = (left << 1) + left;
			int pls = n % cycle;
			if (pls >= left && pls < right) {
				res += (1 << i);
			}
		}
		return res;
	}

	/*
	 * The purpose of this function is to convert an unsigned binary number to
	 * reflected binary Gray code.
	 * 
	 * The operator >> is shift right. The operator ^ is exclusive or.
	 */
	public int binaryToGray(int num) {
		return (num >>> 1) ^ num;
	}

	/*
	 * The purpose of this function is to convert a reflected binary Gray code
	 * number to a binary number.
	 */
	public int grayToBinary(int num) {
		int numBits = 32;
		int shift;
		for (shift = 1; shift < numBits; shift = 2 * shift) {
			num = num ^ (num >> shift);
		}
		return num;
	}
}
