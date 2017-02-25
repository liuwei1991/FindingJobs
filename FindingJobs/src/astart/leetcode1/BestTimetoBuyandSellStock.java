package astart.leetcode1;

public class BestTimetoBuyandSellStock {
	public int maxProfit(int[] prices) {
		int result = 0;
		int lowPriceAhead = Integer.MAX_VALUE;
		for(int price:prices){
			result = Math.max(result, price- lowPriceAhead);
			lowPriceAhead = Math.min(lowPriceAhead, price);
		}
		return result;
    }
}
