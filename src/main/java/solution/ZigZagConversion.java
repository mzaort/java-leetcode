package solution;

public class ZigZagConversion {
	
	public static void main(String[] args) {
		ZigZagConversion zz = new ZigZagConversion();
		System.out.println(zz.convert("PAYPALISHIRING", 2));
	}
	
	public String convert(String s, int nRows) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if(nRows == 1)
			return s;
		int length = s.length() / 2 + nRows;
		char[] cstr = s.toCharArray();
		int[][] mat = new int[nRows][length];
		for (int i = 0; i < nRows; i++) {
			for (int j = 0; j < length; j++) {
				mat[i][j] = -1;
			}
		}

		int locx = 0, locy = 0;
		for (int i = 0; i < cstr.length; i++) {
			mat[locy][locx] = cstr[i];
			if (locx % (nRows - 1) == 0 && locy < nRows - 1) {
				locy++;
			} else {
				locx++;
				locy--;
			}
		}

		StringBuilder resStr = new StringBuilder();
		for (int i = 0; i < nRows; i++) {
			for (int j = 0; j < length; j++) {
				if (mat[i][j] != -1) {
					resStr.append((char)mat[i][j]);
				}
			}
		}

		return new String(resStr);
	}
}
