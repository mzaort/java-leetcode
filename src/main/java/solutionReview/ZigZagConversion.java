package solutionReview;

public class ZigZagConversion {
	public static void main(String[] args) {
		ZigZagConversion zz = new ZigZagConversion();
		System.out.println(zz.convert("PAYPALISHIRING", 2));
	}

	public String convert(String s, int nRows) {
		assert (nRows >= 1);
		int len = s.length();
		if (len <= 1 || nRows <= 1) { return s; }

		int gap = 2 * nRows - 2;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < len; i += gap) {
			sb.append(s.charAt(i));
		}

		for (int i = 1; i < nRows - 1; i++) {
			int frm1 = i;
			int frm2 = gap - i;
			for (; frm2 < len; frm1 += gap, frm2 += gap) {
				sb.append(s.charAt(frm1)).append(s.charAt(frm2));
			}
			if (frm1 < len) {
				sb.append(s.charAt(frm1));
			}
		}

		for (int i = nRows - 1; i < len; i += gap) {
			sb.append(s.charAt(i));
		}
		return new String(sb);
	}
}