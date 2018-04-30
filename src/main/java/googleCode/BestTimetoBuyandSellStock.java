package googleCode;

public class BestTimetoBuyandSellStock {
	public int maxProfit(int[] prices) {
		int res = 0;
		int max = 0;
		for (int i = prices.length - 1; i >= 0; i--) {
			if (max - prices[i] > res) res = max - prices[i];
			if (prices[i] > max) max = prices[i];
		}
		return res;
	}

	public int maxProfit2(int[] prices) {
		int ans = 0;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < prices.length; i++) {
			ans = Math.max(ans, prices[i] - min);
			min = Math.min(min, prices[i]);
		}
		return ans;
	}
}
