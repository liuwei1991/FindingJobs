package leetCode;

public class BestTimetoBuyandSellStock {
	public int maxProfit(int[] prices) {
		if(prices.length==0) return 0;
        for(int i=prices.length-1;i>0;i--){
        	prices[i]=prices[i]-prices[i-1];
        }
        prices[0]=0;
        int dp[] = new int[prices.length+1];
        int ans = 0;
        for(int i=1;i<dp.length;i++){
        	if((dp[i-1]+prices[i-1])>prices[i-1]){
        		dp[i] = dp[i-1]+prices[i-1];
        		
        	}else{
        		dp[i] = prices[i-1];
        	}
        	if(dp[i]>ans) ans = dp[i];
        }
        return ans;
    }
	public static void main(String[] args){
		BestTimetoBuyandSellStock bt = new BestTimetoBuyandSellStock();
		int[] p = {5,3,2,5,4,6,9,7,1};
		System.out.println(bt.maxProfit(p));
	}
}
