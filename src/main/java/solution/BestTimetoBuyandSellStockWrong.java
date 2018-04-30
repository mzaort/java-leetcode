package solution;

public class BestTimetoBuyandSellStockWrong {

	public static void main(String[] args) {
		int[] prices = { 1, 2, 4 };
		System.out.println(new BestTimetoBuyandSellStockWrong().maxProfit(prices));
	}

	public int maxProfit(int[] prices) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (prices.length <= 1) return 0;
		return maxProfit(prices, 0, 0, 0);
	}

	private int maxProfit(int[] prices, int cur, int profit, int stock) {
		int len = prices.length;
		if (cur >= len) { return profit; }
		if (stock >= len - cur) {
			for (int i = cur; i < prices.length; i++) {
				profit += prices[i];
			}
		} else {
			if (prices[cur] == 0) {
				profit = maxProfit(prices, cur + 1, profit, stock);
			} else {
				int buy = maxProfit(prices, cur + 1, profit - prices[cur], stock + 1);
				int sell = stock >= 1 ? maxProfit(prices, cur + 1, profit + prices[cur], stock - 1) : 0;
				profit = maxProfit(prices, cur + 1, profit, stock);
				if (buy > profit) {
					profit = buy;
				}
				if (sell > profit) {
					profit = sell;
				}
			}
		}
		return profit;
	}
}
