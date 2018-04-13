package googleCode;

import java.util.Arrays;

public class BestTimetoBuyandSellStockIII {
	public static void main(String[] args) {
		int[][] a = {{1, 2, 3}, {3, 32, 3}};
		int[][] b = a.clone();
		b[1][1] = 1;
		System.out.println(Arrays.deepToString(a));
		System.out.println(Arrays.deepToString(b));
	}
	
    public int maxProfit(int[] prices) {
    	if(prices.length < 2) return 0;
    	
    	int[] f = new int[prices.length];
    	int min = prices[0];
    	for(int i = 1; i < prices.length; i++){
    		f[i] = prices[i] - min > 0 ? prices[i] - min : 0;
    		if(prices[i] < min) min = prices[i];
    	}
    	int[] g = new int[prices.length];
    	int max = prices[prices.length - 1];
    	for(int i = prices.length - 2; i >= 0; i--){
    		g[i] = max - prices[i] > 0 ? max - prices[i] : 0;
    		if(prices[i] > max) max = prices[i];
    	}
    	
    	for(int i = prices.length - 3; i >= 0; i--){
    		if(g[i] < g[i + 1]) g[i] = g[i + 1];
    	}
    	
    	int res = g[0];
    	for(int i = 1; i < prices.length - 2; i++){
    		if(res < f[i] + g[i + 1]) res = f[i] + g[i + 1];
    	}
    	return res;
    }
    
    public int maxProfit2(int[] prices){
    	if(prices.length < 2) return 0;
    	int[][] mat = new int[2][3];
    	int[][] pre = new int[2][3];
    	for(int cur = prices.length - 1; cur >= 0; cur--){
    		for(int i = 0; i < mat.length; i++){
    			for(int j = 0; j < mat[i].length; j++){
    				mat[i][j] = pre[i][j];
    				if(i == 0 && j > 0 && mat[i][j] < pre[1][j - 1] - prices[cur]) mat[i][j] = pre[1][j - 1] - prices[cur];
    				if(i == 1 && mat[i][j] < pre[0][j] + prices[cur]) mat[i][j] = pre[0][j] + prices[cur];
    			}
    		}
    		pre = mat;
    	}    	
    	return mat[0][2];
    }
    
    public int maxProfit3(int[] prices){
    	if(prices.length < 2) return 0;
    	int[][] mat = new int[2][3];
    	int[][] pre = new int[2][3];
    	for(int cur = prices.length - 1; cur >= 0; cur--){
    		for(int i = 0; i < mat.length; i++){
    			for(int j = 0; j < mat[i].length; j++){
    				if(i == 0 && j > 0 && mat[i][j] < pre[1][j - 1] - prices[cur]) mat[i][j] = pre[1][j - 1] - prices[cur];
    				if(i == 1 && mat[i][j] < pre[0][j] + prices[cur]) mat[i][j] = pre[0][j] + prices[cur];
    			}
    		}
    		int[][] tmp = pre;
    		pre = mat;
    		mat = tmp;
    	}    	
    	return mat[0][2];
    }
}
