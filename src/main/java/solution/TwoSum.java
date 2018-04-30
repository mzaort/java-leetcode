package solution;

public class TwoSum {

	public static void main(String[] args) {
		int[] numbers = { 150, 24, 79, 50, 88, 345, 3 };
		int target = 200;
		TwoSum ts = new TwoSum();
		int[] res = ts.twoSum(numbers, target);
	}

	public int[] twoSum(int[] numbers, int target) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int[] res = null;
		for (int i = 0; i < numbers.length - 1; i++) {
			int ask = target - numbers[i];
			for (int j = i + 1; j < numbers.length; j++) {
				if (numbers[j] == ask) {
					res = new int[2];
					res[0] = i + 1;
					res[1] = j + 1;
					return res;
				}
			}
		}
		return res;
	}

}
