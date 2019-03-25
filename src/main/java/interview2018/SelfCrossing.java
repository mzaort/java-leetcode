package interview2018;

public class SelfCrossing {
	public boolean isSelfCrossing(int[] x) {
		if (x.length < 4) return false;
		int[][] p = new int[6][2];
		int i = 0, j = 5, k = 0;
		int[][] dir = { { 0, 1 }, { -1, 0 }, { 0, -1 }, { 1, 0 } };
		for (int h = 0; h < x.length; h++) {
			int e = x[h];
			int[] next = { p[j][0] + dir[k][0] * e, p[j][1] + dir[k][1] * e };
			if (cross(p[i], p[(i + 1) % 6], p[j], next)) return true;
			if (cross(p[(i + 1) % 6], p[(i + 2) % 6], p[j], next)) return true;
			if (cross(p[(i + 2) % 6], p[(i + 3) % 6], p[j], next)) return true;
			j = (j + 1) % 6;
			i = (i + 1) % 6;
			k = (k + 1) % 4;
			p[j] = next;
		}
		return false;
	}

	public boolean isSelfCrossing2(int[] x) {
		for (int i = 3; i < x.length; ++i) {
			if (x[i] >= x[i - 2] && x[i - 3] >= x[i - 1]) { return true; }
			if (i >= 4 && x[i - 1] == x[i - 3] && x[i] >= x[i - 2] - x[i - 4]) { return true; }
			if (i >= 5 && x[i - 2] >= x[i - 4] && x[i - 3] >= x[i - 1] && x[i - 1] >= x[i - 3] - x[i - 5]
					&& x[i] >= x[i - 2] - x[i - 4]) { return true; }
		}
		return false;
	}

	private boolean cross(int[] p1, int[] p2, int[] p3, int[] p4) {
		if (p1[0] == p2[0] && p1[1] == p2[1]) return false;
		if (p3[0] == p4[0]) {
			if (p1[0] == p2[0]) {
				return p3[0] == p1[0]
						&& (p4[1] > p3[1] ? p4[1] >= Math.min(p1[1], p2[1]) : p4[1] <= Math.max(p1[1], p2[1]));
			} else {
				return p4[0] >= Math.min(p1[0], p2[0]) && p4[0] <= Math.max(p1[0], p2[0])
						&& p1[1] >= Math.min(p3[1], p4[1]) && p1[1] <= Math.max(p3[1], p4[1]);
			}
		} else {
			if (p1[0] == p2[0]) {
				return p1[0] >= Math.min(p3[0], p4[0]) && p1[0] <= Math.max(p3[0], p4[0])
						&& p4[1] >= Math.min(p1[1], p2[1]) && p4[1] <= Math.max(p1[1], p2[1]);
			} else {
				return p3[1] == p1[1]
						&& (p4[0] > p3[0] ? p4[0] >= Math.min(p1[0], p2[0]) : p4[0] <= Math.max(p1[0], p2[0]));
			}
		}
	}

	public static void main(String[] args) {
		SelfCrossing sc = new SelfCrossing();
		int[] p = { 2, 1, 1, 2 };
		System.out.println(sc.isSelfCrossing(p));
	}
}
