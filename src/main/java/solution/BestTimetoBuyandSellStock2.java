package solution;

public class BestTimetoBuyandSellStock2 {

	public static void main(String[] args) {
		int[] prices = { 1, 2, 4 };
		System.out.println(new BestTimetoBuyandSellStock2().maxProfit(prices));
	}

	public int maxProfit(int[] prices) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (prices.length <= 1) return 0;
		return maxProfit(prices, 0, 0, 0);
	}

	private int maxProfit(int[] prices, int cur, int stock, int profit) {
		int len = prices.length;
		if (cur < len) {
			if (stock == 0) {
				int buy = maxProfit(prices, cur + 1, 1, profit - prices[cur]);
				profit = maxProfit(prices, cur + 1, 0, profit);
				if (buy > profit) {
					profit = buy;
				}
			} else {
				int sell = maxProfit(prices, cur + 1, 0, profit + prices[cur]);
				profit = maxProfit(prices, cur + 1, 1, profit);
				if (sell > profit) {
					profit = sell;
				}
			}
		}
		return profit;
	}
}
