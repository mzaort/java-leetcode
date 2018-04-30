package solution;

public class BestTimetoBuyandSellStockIII {

	public static void main(String[] args) {
		BestTimetoBuyandSellStockIII bbss = new BestTimetoBuyandSellStockIII();
		System.out.println(bbss.maxProfit(new int[] { 2, 1 }));
	}

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

		max[len - 1] = 0;
		for (int i = len - 2; i >= 0; i--) {
			int profit = max[i] - prices[i];
			if (profit > max[i + 1]) {
				max[i] = profit;
			} else {
				max[i] = max[i + 1];
			}
		}

		int profit = max[0];
		for (int cut = 2; cut < len - 1; cut++) {
			max[cut - 2] = prices[cut - 1];
			for (int i = cut - 3; i >= 0; i--) {
				max[i] = max[i + 1] > prices[i + 1] ? max[i + 1] : prices[i + 1];
			}
			int ptmp = 0;
			for (int i = 0; i < cut - 1; i++) {
				ptmp = max[i] - prices[i] > ptmp ? max[i] - prices[i] : ptmp;
			}
			profit = ptmp + max[cut] > profit ? ptmp + max[cut] : profit;
		}

		return profit;
	}
}
