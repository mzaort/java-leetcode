package interview2018;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> list = new ArrayList<>();
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return list;
		int m = matrix.length - 1;
		int n = matrix[0].length;
		int i = -1, j = -1, c = 0;
		while (true) {
			if (n <= 0) break;
			for (i++, j++, c = n; c > 0; list.add(matrix[i][j]), c--, j++);
			n--;
			if (m <= 0) break;
			for (j--, i++, c = m; c > 0; list.add(matrix[i][j]), c--, i++);
			m--;
			if (n <= 0) break;
			for (i--, j--, c = n; c > 0; list.add(matrix[i][j]), c--, j--);
			n--;
			if (m <= 0) break;
			for (j++, i--, c = m; c > 0; list.add(matrix[i][j]), c--, i--);
			m--;
		}
		return list;
	}

	public List<Integer> spiralOrder2(int[][] matrix) {
		List<Integer> list = new ArrayList<>();
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return list;
		int m = matrix.length - 1;
		int n = matrix[0].length;
		int i = 0, j = -1, c = 0;
		while (true) {
			if (n <= 0) break;
			for (c = n; c > 0; j++, list.add(matrix[i][j]), c--);
			n--;
			if (m <= 0) break;
			for (c = m; c > 0; i++, list.add(matrix[i][j]), c--);
			m--;
			if (n <= 0) break;
			for (c = n; c > 0; j--, list.add(matrix[i][j]), c--);
			n--;
			if (m <= 0) break;
			for (c = m; c > 0; i--, list.add(matrix[i][j]), c--);
			m--;
		}
		return list;
	}

	public List<Integer> spiralOrder3(int[][] matrix) {
		List<Integer> list = new ArrayList<>();
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return list;
		int[] len = { matrix[0].length, matrix.length - 1 };
		int[] loc = { 0, -1 };
		int[][] dir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

		int cur = 0;
		while (len[cur % 2] > 0) {
			for (int count = len[cur % 2]; count > 0; count--) {
				loc[0] += dir[cur][0];
				loc[1] += dir[cur][1];
				list.add(matrix[loc[0]][loc[1]]);
			}
			len[cur % 2]--;
			cur = (cur + 1) % 4;
		}
		return list;
	}

	public static void main(String[] args) {
		int[][] mat = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		SpiralMatrix sm = new SpiralMatrix();
		System.out.println(sm.spiralOrder3(mat));
	}
}
