package astart.leetcode1;

public class MinimumPathSum {
	public int minPathSum(int[][] grid) {
		if(grid==null||grid.length==0||grid[0].length==0){
        	return 0;
        }
		int[][] dp = new int[grid.length][grid[0].length];
		dp[0][0] = grid[0][0];
		for(int i=1;i<grid.length;i++){
			dp[i][0] = dp[i-1][0]+grid[i][0];
		}
		for(int j=1;j<grid[0].length;j++){
			dp[0][j] = dp[0][j-1]+grid[0][j];
		}
		for(int i=1;i<grid.length;i++){
			for(int j=1;j<grid[0].length;j++){
				dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1])+grid[i][j];
			}
		}
		return dp[grid.length-1][grid[0].length-1];
    }
	
	public int floyd(int[][] grid){
		if(grid==null||grid.length==0){
        	return 0;
        }
        for(int k=0;k<grid.length;k++){
        	for(int i=0;i<grid.length;i++){
        		for(int j=0;j<grid[0].length;j++){
        			if(grid[i][j]>grid[i][k]+grid[k][j]){
        				grid[i][j] = grid[i][k]+grid[k][j];
        			}
        		}
        	}
        }
        return grid[0][grid.length-1];
	}
	
	public static void main(String[] args){
		MinimumPathSum  mp = new MinimumPathSum();
		int[][] grid = {{1,2},{1,1}};
		System.out.println(mp.minPathSum(grid));
	}
}
