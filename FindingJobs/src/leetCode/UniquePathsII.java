package leetCode;

public class UniquePathsII {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int[][] num = new int[obstacleGrid.length][obstacleGrid[0].length];
		for(int i=0;i<num.length;i++){
			for(int j=0;j<num[0].length;j++){
				num[i][j]=-1;
			}
		}
		this.dfs(num,obstacleGrid, 0, 0);
		return num[0][0];
    }
	public int dfs(int[][] num,int[][] a, int row,int column){
		if(a[row][column]==1){
			num[row][column]=0;
			return 0;
		}
		if(num[row][column]>=0){
			return num[row][column];
		}
		if(row==a.length-1 && column==a[0].length-1){
			if(a[row][column]==0){
				num[row][column] = 1;
				return 1;
			}
			num[row][column] =0;
			return 0;
		}
		int current = 0;
		if(row+1<a.length && a[row+1][column]==0){
			num[row+1][column] = this.dfs(num,a, row+1, column);
			current+=num[row+1][column];
		}
		if(column+1<a[0].length && a[row][column+1]==0){
			num[row][column+1] = this.dfs(num,a, row, column+1);
			current += num[row][column+1];
		}
		num[row][column] = current;
		return current;
	}
	public static void main(String[] args){
		UniquePathsII up = new UniquePathsII();
		int[][] a ={
				{1,0}
//				{0,0,0},
//				{0,1,0},
//				{0,0,0}
		};
		System.out.println(up.uniquePathsWithObstacles(a));
	}
}
