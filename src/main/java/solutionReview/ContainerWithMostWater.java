package solutionReview;

public class ContainerWithMostWater {

	public static void main(String[] args) {
		int[] height = { 2, 1, 8, 2 };
		ContainerWithMostWater cww = new ContainerWithMostWater();
		System.out.println(cww.maxArea3(height));
	}

	public int maxArea(int[] height) {
		int len = height.length;
		if (len <= 1) return 0;

		int res = 0;
		for (int i = 0; i < len - 1; i++) {
			for (int j = i + 1; j < len; j++) {
				int h = height[i] > height[j] ? height[j] : height[i];
				int tmp = h * (j - i);
				if (tmp > res) {
					res = tmp;
				}
			}
		}
		return res;
	}

	public int maxArea2(int[] height) {
		int len = height.length;
		if (len <= 1) return 0;

		int frm = 0, end = len - 1;

		int res = 0;
		while (frm < end) {
			int h = height[frm] > height[end] ? height[end] : height[frm];
			int tmp = h * (end - frm);
			if (tmp > res) {
				res = tmp;
			}
			if (height[frm] > height[end]) {
				end--;
			} else {
				frm++;
			}
		}
		return res;
	}

	public int maxArea3(int[] height) {
		int len = height.length;
		if (len <= 1) return 0;

		int frm = 0, end = len - 1;

		int res = 0;
		while (frm < end) {
			int tmp = end - frm;
			if (height[frm] > height[end]) {
				tmp *= height[end];
				end--;
			} else {
				tmp *= height[frm];
				frm++;
			}
			if (tmp > res) {
				res = tmp;
			}
		}
		return res;
	}
}