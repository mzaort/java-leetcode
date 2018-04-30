package googleCode;

public class ZigZagConversion {
	public static void main(String[] args) {
		ZigZagConversion zzc = new ZigZagConversion();
		System.out.println(zzc.convert("PAYPALISHIRING", 3));
		System.out.println(zzc.reverseConvert("PAHNAPLSIIGYIR", 3));
	}

	public String convert(String s, int nRows) {
		assert (nRows > 0);
		if (nRows == 1) return s;

		StringBuilder sb = new StringBuilder();
		int step = 2 * nRows - 2;
		for (int i = 0; i < s.length(); i += step)
			sb.append(s.charAt(i));
		for (int i = 1; i < nRows - 1; i++) {
			int frm1 = i, frm2 = step - i;
			for (; frm2 < s.length(); frm1 += step, frm2 += step)
				sb.append(s.charAt(frm1)).append(s.charAt(frm2));
			if (frm1 < s.length()) sb.append(s.charAt(frm1));
		}
		for (int i = nRows - 1; i < s.length(); i += step)
			sb.append(s.charAt(i));
		return new String(sb);
	}

	public String reverseConvert(String s, int nRows) {
		assert (nRows > 0);
		if (nRows == 1) return s;

		int step = 2 * nRows - 2;
		int cycle = s.length() / step;

		int total = 0;
		int[] num = new int[nRows];
		num[0] = 0;
		total += cycle + (cycle * step < s.length() ? 1 : 0);
		for (int i = 1; i < num.length - 1; i++) {
			num[i] = total;
			total += 2 * cycle;
			if (step - i + cycle * step < s.length()) total += 2;
			else if (i + cycle * step < s.length()) total++;
		}
		num[num.length - 1] = total;

		StringBuilder sb = new StringBuilder(s.length());
		int r = -1, direction = 0;
		for (int i = 0; i < s.length(); i++) {
			if (direction == 0) {
				r++;
				if (r == nRows - 1) direction = 1;
			} else {
				r--;
				if (r == 0) direction = 0;
			}
			sb.append(s.charAt(num[r]++));
		}

		return new String(sb);
	}
}
