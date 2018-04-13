package solution;

public class MaximalRectangle {
	public int WrongmaximalRectangle(char[][] matrix) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return 0;

		int x1, y1, x2, y2;
		x1 = y1 = Integer.MAX_VALUE;
		y2 = x2 = Integer.MIN_VALUE;

		boolean flag = false;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == '1') {
					flag = true;
					if (i < x1)
						x1 = i;
					if (i > x2)
						x2 = i;
					if (j < y1)
						y1 = j;
					if (j > y2)
						y2 = j;
				}
			}
		}

		if (flag) {
			return (x2 - x1 + 1) * (y2 - y1 + 1);
		} else {
			return 0;
		}

	}

	public int maximalRectangle(char[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return 0;

		int hx = matrix.length, hy = matrix[0].length;
		int[][] reach = new int[hx][hy];
		for (int i = 0; i < hx; i++) {
			reach[i][hy - 1] = matrix[i][hy - 1] == '1' ? 1 : 0;
			for (int j = hy - 2; j >= 0; j--) {
				reach[i][j] = matrix[i][j] == '1' ? reach[i][j + 1] + 1 : 0;
			}
		}

		int largest = 0;
		for (int i = 0; i < hx; i++) {
			for (int j = 0; j < hy; j++) {
				if (matrix[i][j] == '1') {
					for (int k = i, height = 1, min = reach[i][j]; k < hx && matrix[k][j] == '1'; k++, height++) {
						if (min > reach[k][j]) {
							min = reach[k][j];
						}
						int tmp = min * height;
						if (tmp > largest) {
							largest = tmp;
						}
					}
				}
			}
		}
		return largest;
	}
	
	public int maximalRectangle2(char[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return 0;

		int hx = matrix.length, hy = matrix[0].length;
		int[][] reach = new int[hx][hy];
		for (int i = 0; i < hx; i++) {
			reach[i][hy - 1] = matrix[i][hy - 1] == '1' ? 1 : 0;
			for (int j = hy - 2; j >= 0; j--) {
				reach[i][j] = matrix[i][j] == '1' ? reach[i][j + 1] + 1 : 0;
			}
		}
		
		boolean[][] flag = new boolean[hx][hy];
		for(int i = 0; i < hx; i++){
			for(int j = 0; j < hy; j++){
				flag[i][j] = matrix[i][j] == '1'?true:false; 
			}
		}

		int largest = 0;
		for (int i = 0; i < hx; i++) {
			for (int j = 0; j < hy; j++) {
				if (flag[i][j]) {
					for (int k = i, height = 1, min = reach[i][j]; k < hx && matrix[k][j] == '1'; k++, height++) {
						if (min > reach[k][j]) {
							flag[k][j] = false;
							min = reach[k][j];
						}
						int tmp = min * height;
						if (tmp > largest) {
							largest = tmp;
						}
					}
				}
			}
		}
		return largest;
	}
}
