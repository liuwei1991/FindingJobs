package leetCode;

public class MinimumPathSum {
	public MinimumPathSum(){
		System.out.println("mps");
	}
	public int minPathSum(int[][] grid) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
		int[][] dp= new int[grid.length][grid[0].length];
		dp[0][0]=grid[0][0];
		
		for(int i = 1;i<dp.length;i++){
			dp[i][0] += dp[i-1][0]+grid[i][0];
		}
		for(int i=1;i<dp[0].length;i++){
			dp[0][i] = dp[0][i-1]+grid[0][i];
		}
		
		for(int i=1;i<grid.length;i++){
			for(int j=1;j<grid[0].length;j++){
				dp[i][j] = (dp[i-1][j]>dp[i][j-1]?dp[i][j-1]:dp[i-1][j])+grid[i][j];
			}
		}
		
        return dp[grid.length-1][grid[0].length-1];
    }
	
	
	public static void main(String args[]){
		int[][] grid = {{1,2,3},{3,2,5},{5,3,4}};
		MinimumPathSum m = new MinimumPathSum();
		System.out.println(m.minPathSum(grid));
	}
}
