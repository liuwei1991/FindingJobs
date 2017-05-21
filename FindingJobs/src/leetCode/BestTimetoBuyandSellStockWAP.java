package leetCode;

public class BestTimetoBuyandSellStockWAP {
	public int maxProfit(int[] prices) {
		if(prices ==null){
			return 0;
		}
		if(prices.length==0){
			return 0;
		}
		for (int i = prices.length - 1; i > 0; i--) {
			prices[i] -= prices[i - 1];
		}
		prices[0] = 0;
		int dp[] = new int[prices.length];
		int max = 0;
		for(int i=1;i<prices.length;i++){
			dp[i] = Math.max(prices[i], dp[i-1]+prices[i]);
			max = Math.max(max, dp[i]);
		}
		return max;
	}
	
	public static void main(String[] args){
		BestTimetoBuyandSellStockWAP bt = new BestTimetoBuyandSellStockWAP();
		int[] prices = {};
		System.out.println(bt.maxProfit(prices));
	}
}
