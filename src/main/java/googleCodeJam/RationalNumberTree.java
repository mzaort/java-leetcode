package googleCodeJam;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Scanner;

public class RationalNumberTree {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sin = new Scanner(new File("E:\\Document\\B-large-practice (1).in"));
		PrintWriter pwr = new PrintWriter(new File("test.out"));
		RationalNumberTree rnt = new RationalNumberTree();
		int cnt = sin.nextInt();
		for (int k = 1; k <= cnt; k++) {
			int problem = sin.nextInt();
			if (problem == 1) {
				long[] val = rnt.findPQ2(rnt.str2ulong(sin.nextLine().trim()));
				pwr.println("Case #" + k + ": " + Long.toUnsignedString(val[0]) + " " + Long.toUnsignedString(val[1]));
			} else if (problem == 2) {
				String[] pq = sin.nextLine().trim().split("\\s");
				long val = rnt.findN2(Long.parseUnsignedLong(pq[0]), Long.parseUnsignedLong(pq[1]));
				pwr.println("Case #" + k + ": " + Long.toUnsignedString(val));
			}
		}
		sin.close();
		pwr.close();
	}

	private long findN2(long p, long q) {
		StringBuilder sb = new StringBuilder();
		while (!(p == 1 && q == 1)) {
			if (Long.compareUnsigned(p, q) > 0) {
				sb.append('1');
				p -= q;
			} else {
				sb.append('0');
				q -= p;
			}
		}
		return Long.parseUnsignedLong(sb.append("1").reverse().toString(), 2);
	}

	private long findN(long p, long q) {
		if (p == 1 && q == 1) return 1;
		if (p < 0 && q < 0) return p > q ? (findN(p, q - p) << 1) : (findN(p - q, q) << 1) + 1;
		else if (p < 0) return (findN(p - q, q) << 1) + 1;
		else if (q < 0) return (findN(p, q - p) << 1);
		else return p < q ? (findN(p, q - p) << 1) : (findN(p - q, q) << 1) + 1;
	}

	private long str2ulong(String str) {
		BigInteger big = new BigInteger(str);
		if (big.compareTo(BigInteger.ONE.shiftLeft(63)) >= 0) {
			big = big.subtract(BigInteger.ONE.shiftLeft(64));
		}
		return big.longValue();
	}

	private String ulong2str(long val) {
		BigInteger big = new BigInteger(new Long(val & 0x7fffffffffffffffL).toString());
		if (val < 0) big = big.add(BigInteger.ONE.shiftLeft(63));
		return big.toString();
	}

	private long[] findPQ(long n) {
		boolean[] flag = new boolean[64];
		int cur = 0;
		for (; n != 0; cur++, n >>>= 1) {
			flag[cur] = (n & 1) == 1;
		}
		long[] res = { 1, 1 };
		for (int i = cur - 2; i >= 0; i--) {
			if (flag[i]) {
				res[0] += res[1];
			} else {
				res[1] += res[0];
			}
		}
		return res;
	}

	private long[] findPQ2(long n) {
		long[] res = { 1, 1 };
		String s = Long.toBinaryString(n);
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) == '0') res[1] += res[0];
			else res[0] += res[1];
		}
		return res;
	}

}
