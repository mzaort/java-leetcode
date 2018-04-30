package interview2018;

public class MoveZeroes {
	public void moveZeroesDisorder(int[] nums) {
		int frm = 0, end = nums.length - 1;
		while (frm < end) {
			int i = frm, j = end;
			for (; i <= j && nums[i] != 0; i++);
			for (; i <= j && nums[j] == 0; j--);
			if (i < j) {
				int tmp = nums[i];
				nums[i] = nums[j];
				nums[j] = tmp;
			}
			frm = i + 1;
			end = j - 1;
		}
	}

	public void moveZeroes(int[] nums) {
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) count++;
			else nums[i - count] = nums[i];
		}
		for (int i = nums.length - 1; count > 0; count--, i--) {
			nums[i] = 0;
		}
	}
}
