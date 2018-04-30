package solution;

import java.util.Arrays;

public class ValidSudoku {
	public boolean isValidSudoku(char[][] board) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (board == null || board.length != 9 || board[0].length != 9) return false;

		int[] mask = new int[10];
		char ch;

		for (int i = 0; i < 9; i++) {
			Arrays.fill(mask, 1);
			for (int j = 0; j < 9; j++) {
				if ((ch = board[i][j]) != '.') {
					if (mask[ch - '0'] == 0) {
						return false;
					} else {
						mask[ch - '0'] = 0;
					}
				}
			}
		}

		for (int j = 0; j < 9; j++) {
			Arrays.fill(mask, 1);
			for (int i = 0; i < 9; i++) {
				if ((ch = board[i][j]) != '.') {
					if (mask[ch - '0'] == 0) {
						return false;
					} else {
						mask[ch - '0'] = 0;
					}
				}
			}
		}

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				Arrays.fill(mask, 1);
				for (int k = 3 * i; k < 3 * i + 3; k++) {
					for (int h = 3 * j; h < 3 * j + 3; h++) {
						if ((ch = board[k][h]) != '.') {
							if (mask[ch - '0'] == 0) {
								return false;
							} else {
								mask[ch - '0'] = 0;
							}
						}
					}
				}
			}
		}

		return true;
	}
}
