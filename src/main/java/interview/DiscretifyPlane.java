package interview;

import java.util.Arrays;

public class DiscretifyPlane {

	public int area(Rectangle[] rec) {
		if (rec.length == 0) return 0;
		int[] x = new int[rec.length * 2];
		int[] y = new int[rec.length * 2];
		for (int i = 0, j = 0, k = 0; i < rec.length; i++) {
			x[j++] = rec[i].x1;
			x[j++] = rec[i].x2;
			y[k++] = rec[i].y1;
			y[k++] = rec[i].y2;
		}
		Arrays.sort(x);
		Arrays.sort(y);
		int[][] flag = new int[rec.length * 2][rec.length * 2];
		for (int i = 0; i < rec.length * 2; i++) {
			for (int j = 0; j < rec.length * 2; j++) {
				flag[i][j] = 0;
			}
		}

		for (Rectangle e : rec) {
			int xfrm = Arrays.binarySearch(x, e.x1);
			int xend = Arrays.binarySearch(x, e.x2);
			int yfrm = Arrays.binarySearch(y, e.y2);
			int yend = Arrays.binarySearch(y, e.y1);
			for (int i = xfrm; i < xend; i++) {
				for (int j = yfrm; j < yend; j++) {
					flag[i][j] = 1;
				}
			}
		}

		int res = 0;
		for (int i = 0; i < rec.length * 2 - 1; i++) {
			for (int j = 0; j < rec.length * 2 - 1; j++) {
				if (flag[i][j] == 1) {
					res += (x[i + 1] - x[i]) * (y[i + 1] - y[i]);
				}
			}
		}
		return res;
	}

	public static class Rectangle {
		private int x1;
		private int y1;
		private int x2;
		private int y2;

		public Rectangle(int x1, int y1, int x2, int y2) {
			assert (x1 < x2 && y1 > y2);
			this.x1 = x1;
			this.x2 = x2;
			this.y1 = y1;
			this.y2 = y2;
		}
	}
}
