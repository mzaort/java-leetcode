package googleCode;

public class BestTimetoBuyandSellStockII {
	public static void main(String[] args) {
		BestTimetoBuyandSellStockII bbs = new BestTimetoBuyandSellStockII();
		System.out.println(bbs.maxProfit(new int[]{1, 4, 6, 2, 4, 1}));
	}
	
    public int maxProfit(int[] prices) {
    	int res = 0;
    	int i = -1;
    	int limit = prices.length - 1;
    	while(true){
			for(i++; i < limit && prices[i] >= prices[i + 1]; i++);
    		if(i >= limit) return res;
    		int buy = prices[i];
    		for(i++; i < limit && prices[i] <= prices[i + 1]; i++);
    		res += prices[i] - buy;
    	}
    }
    
    public int maxProfit2(int[] prices) {
    	int res = 0;
    	for(int i = 0, j = 1; j < prices.length; i++, j++){
    		if(prices[j] - prices[i] > 0) res += prices[j] - prices[i];
    	}
    	return res;
    }
    
    public int maxProfit3(int[] prices){
    	int ans = 0;
    	for(int i = 0; i < prices.length; i++){
    		for(; i + 1 < prices.length && prices[i] >= prices[i + 1]; i++);
    		int buy = i;
    		for(i++; i + 1 < prices.length && prices[i] <= prices[i + 1]; i++);
    		if(i < prices.length) ans += prices[i] - prices[buy];
    	}
    	return ans;
    }
}
