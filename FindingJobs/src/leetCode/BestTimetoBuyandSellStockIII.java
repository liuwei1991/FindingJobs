package leetCode;

public class BestTimetoBuyandSellStockIII {
	public int maxProfit(int[] prices) {
		if(prices==null || prices.length==0 || prices.length==1){
			return 0;
		}
		int maxProfit[] = new int[prices.length];
		int lowest = prices[0];
		for(int i=1;i<prices.length;i++){
			maxProfit[i] = prices[i]-lowest;
			if(lowest>prices[i]){
				lowest = prices[i];
			}
		}
		
		int highest = prices[prices.length-1];
		int result = maxProfit[prices.length-1];
		int max = 0;
		for(int i=prices.length-1;i>=0;i--){
			if(max<highest-prices[i]){
				max = highest-prices[i];
			}
			if(result<(max+maxProfit[i])){
				result = (max+maxProfit[i]);
			}
			if(prices[i]>highest){
				highest = prices[i];
			}
		}
		return result;
	}
	
	public static void main(String[] args){
		BestTimetoBuyandSellStockIII bt = new BestTimetoBuyandSellStockIII();
//		int[] prices = {1,2,4};
		int prices[] = {1,2,4,2,5,7,2,4,9,0};
		System.out.println(bt.maxProfit(prices));
	}
}
