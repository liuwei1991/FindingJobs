package astart.leetcode1;

public class BestTimetoBuyandSellStockII {
	public int maxProfit(int[] prices) {
		int r = 0;
        for(int i=1;i<prices.length;i++){
        	int profit = prices[i] - prices[i-1];
        	if(profit>0){
        		r+=profit;
        	}
        }
        return r;
    }
}
