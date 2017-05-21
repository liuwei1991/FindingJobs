package astart.leetcode1;

public class BestTimetoBuyandSellStockIII {
	public int maxProfit(int[] prices) {
        int result = 0;
        if(prices==null||prices.length<=1){
        	return result;
        }
        int[] pre = new int[prices.length];
        int[] post = new int[prices.length];
        int preMin = prices[0];
        for(int i=1;i<prices.length;i++){
        	preMin = Math.min(preMin, prices[i]);
        	pre[i] = Math.max(prices[i]-preMin,pre[i-1]);
        }
        int postHigh = prices[prices.length-1];
        for(int i=prices.length-2;i>=0;i--){
        	postHigh = Math.max(postHigh, prices[i]);
        	post[i] = Math.max(postHigh - prices[i],post[i+1]);
        }
        
        for(int i=0;i<prices.length;i++){
        	result = Math.max(result, pre[i]+post[i]);
        }
        return result;
    }
	
	public static void main(String[] args){
		BestTimetoBuyandSellStockIII bs = new BestTimetoBuyandSellStockIII();
		int[] prices = {2,1,2,0,1};
		System.out.println(bs.maxProfit(prices));
	}
}
