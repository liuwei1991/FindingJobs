package leetCode;

public class ClimbingStairs {
	public int dp[];
	public int solve(int n){
		if(n==0) return 0;
		if(dp[n]!=0) return dp[n];
		dp[n] = this.solve(n-1)+this.solve(n-2);
		return dp[n];
	}
	public int climbStairs(int n){
		this.dp = new int[n+1];
		if(n==0) return 0;
		if(n==1) return 1;
		dp[1]=1;
		dp[0]=1;
		return this.solve(n);
	}
}
