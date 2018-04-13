package solution;

import java.util.ArrayList;

public class SpiralMatrix {
	public static void main(String[] args) {
		int[][] matrix = {{2}, {3}};
		SpiralMatrix sm = new SpiralMatrix();
		System.out.println(sm.spiralOrder(matrix));
	}
	
	public ArrayList<Integer> spiralOrder(int[][] matrix) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<Integer> res = new ArrayList<Integer>();
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return res;

		int hx = matrix.length - 1, hy = matrix[0].length, locx = 0, locy = -1, orient = 0;

		boolean flag = true;
		while (flag) {
			switch (orient) {
			case 0:
				for (int i = 0; i < hy; i++) {
					res.add(matrix[locx][++locy]);
				}
				if (hx == 0)
					flag = false;
				orient++;
				hy--;
				break;
			case 1:
				for (int i = 0; i < hx; i++) {
					res.add(matrix[++locx][locy]);
				}
				if (hy == 0)
					flag = false;
				orient++;
				hx--;
				break;
			case 2:
				for (int i = 0; i < hy; i++) {
					res.add(matrix[locx][--locy]);
				}
				if (hx == 0)
					flag = false;
				orient++;
				hy--;
				break;
			case 3:
				for (int i = 0; i < hx; i++) {
					res.add(matrix[--locx][locy]);
				}
				if (hy == 0)
					flag = false;
				orient = 0;
				hx--;
				break;
			}
		}

		return res;
	}
}
