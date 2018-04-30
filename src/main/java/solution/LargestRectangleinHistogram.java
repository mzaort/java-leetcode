package solution;

public class LargestRectangleinHistogram {
	public static void main(String[] args) {
		int height[] = { 2, 4 };
		System.out.println(new LargestRectangleinHistogram().largestRectangleArea5(height));
	}

	public int largestRectangleArea(int[] height) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (height == null || height.length == 0) return 0;
		int len = height.length;
		int[][] min = new int[len][len];
		for (int i = 0; i < len; i++) {
			min[i][i] = height[i];
		}

		for (int i = len - 2; i >= 0; i--) {
			for (int j = i + 1; j < len; j++) {
				min[i][j] = min[i + 1][j] > height[i] ? height[i] : min[i + 1][j];
			}
		}

		int largest = -1;
		for (int i = 0; i < len; i++) {
			for (int j = i; j < len; j++) {
				int tmp = (j - i + 1) * min[i][j];
				if (largest < tmp) {
					largest = tmp;
				}
			}
		}
		return largest;
	}

	public int largestRectangleArea2(int[] height) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (height == null || height.length == 0) return 0;
		int len = height.length;

		int largest = -1;
		for (int i = 0; i < len; i++) {
			int min = height[i];
			for (int j = i; j < len; j++) {
				if (min > height[j]) {
					min = height[j];
				}
				int tmp = min * (j - i + 1);
				if (largest < tmp) {
					largest = tmp;
				}
			}
		}
		return largest;
	}

	public int largestRectangleArea3(int[] height) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (height == null || height.length == 0) return 0;
		int len = height.length;

		int[] min = new int[len];
		System.arraycopy(height, 0, min, 0, len);

		int largest = -1;
		for (int i = 0; i < len; i++) {
			if (height[i] > largest) largest = height[i];
		}

		for (int i = 2; i <= len; i++) {
			for (int j = 0; j < len - i + 1; j++) {
				if (min[j] > height[i + j - 1]) min[j] = height[i + j - 1];
			}
			for (int j = 0; j < len - i + 1; j++) {
				int tmp = i * min[j];
				if (largest < tmp) largest = tmp;
			}
		}

		return largest;
	}

	public int largestRectangleArea4(int[] height) {
		if (height == null || height.length == 0) return 0;
		int len = height.length;
		int largest = -1;

		for (int i = 0; i < len; i++) {
			int top = height[i];
			int left = i, right = i;
			for (; left >= 0 && height[left] >= top; left--);
			for (; right < len && height[right] >= top; right++);
			int tmp = (right - left - 1) * top;
			if (largest < tmp) {
				largest = tmp;
			}
		}

		return largest;
	}

	public int largestRectangleArea5(int[] height) {
		if (height == null || height.length == 0) return 0;
		int len = height.length;
		int largest = -1;

		int min = height[0];
		for (int i = 1; i < len; i++) {
			if (min > height[i]) {
				min = height[i];
			}
		}

		largest = min * len;

		for (int i = 0; i < len; i++) {
			int top = height[i];
			if (top == min) {
				continue;
			}
			int left = i, right = i;
			for (; left >= 0 && height[left] >= top; left--);
			for (; right < len && height[right] >= top; right++);
			int tmp = (right - left - 1) * top;
			if (largest < tmp) {
				largest = tmp;
			}
			if (left < 0 && right >= len) {
				break;
			}
		}

		return largest;
	}

	public int WronglargestRectangleArea5(int[] height) {
		if (height == null || height.length == 0) return 0;
		int len = height.length;

		int[] maxLeft = new int[len];
		maxLeft[0] = 1;
		for (int i = 1; i < len; i++) {
			maxLeft[i] = (height[i] <= height[i - 1]) ? maxLeft[i - 1] + 1 : 1;
		}

		int[] maxRight = new int[len];
		maxRight[len - 1] = 1;
		for (int i = len - 2; i >= 0; i--) {
			maxRight[i] = (height[i] <= height[i + 1]) ? maxRight[i + 1] + 1 : 1;
		}

		for (int i = 0; i < len; i++) {
			maxLeft[i] = maxLeft[i] + maxRight[i] - 1;
		}

		int largest = -1;
		for (int i = 0; i < len; i++) {
			int tmp = maxLeft[i] * height[i];
			if (largest < tmp) {
				largest = tmp;
			}
		}

		return largest;
	}
}
