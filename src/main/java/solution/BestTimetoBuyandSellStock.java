package solution;

public class BestTimetoBuyandSellStock {
	public int maxProfit(int[] prices) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int len = prices.length;
		if (len <= 1) return 0;

		int[] max = new int[len];
		max[len - 2] = prices[len - 1];
		for (int i = len - 3; i >= 0; i--) {
			max[i] = max[i + 1] > prices[i + 1] ? max[i + 1] : prices[i + 1];
		}

		int res = prices[1] - prices[0];
		for (int i = 0; i < len - 1; i++) {
			int tmp = max[i] - prices[i];
			if (tmp > res) {
				res = tmp;
			}
		}
		return res > 0 ? res : 0;
	}
}
