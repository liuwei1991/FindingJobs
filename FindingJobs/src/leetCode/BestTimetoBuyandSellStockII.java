package leetCode;

public class BestTimetoBuyandSellStockII {
	public int maxProfit(int[] prices) {
		int profit = 0;
		if(prices.length<2){
			return 0;
		}
		for(int i=1;i<prices.length;i++){
			if(prices[i-1]<prices[i]){
				profit+=prices[i]-prices[i-1];
			}
		}
		return profit;
    }
	
	public static void main(String[] args){
		BestTimetoBuyandSellStockII btb = new BestTimetoBuyandSellStockII();
		int[] prices = {3,4,2,6,7,3,2,1};
		System.out.println(btb.maxProfit(prices));
	}
}
