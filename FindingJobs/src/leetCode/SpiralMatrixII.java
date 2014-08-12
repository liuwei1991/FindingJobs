package leetCode;

public class SpiralMatrixII {
	public int[][] generateMatrix(int n) {
		int[][] result = new int[n][n];
		int direction = 0;//0 for left,1 for down, 2 for right, 3 for up
		int row = 0;
		int column = 0;
		for(int i=1;i<=n*n;i++){
			switch(direction){
				case 0:{
					if(column+1>=n || result[row][column+1]!=0){
						result[row][column] = i;
						row++;
						direction =1;
					}else{
						result[row][column] = i;
						column++;
					}
					break;
				}
				case 1:{
					if(row+1>=n || result[row+1][column]!=0){
						result[row][column] = i;
						column--;
						direction = 2;
					}else{
						result[row][column] = i;
						row++;
					}
					break;
				}
				case 2:{
					if(column-1<0 || result[row][column-1]!=0){
						result[row][column]=i;
						row--;
						direction = 3;
					}else{
						result[row][column] = i;
						column--;
					}
					break;
				}
				case 3:{
					if(row-1<0 || result[row-1][column]!=0){
						result[row][column] = i;
						column++;
						direction = 0;
					}else{
						result[row][column]=i;
						row--;
					}
					break;
				}
			}
		}
		return result;
    }
	
	public static void main(String[] args){
		SpiralMatrixII sm = new SpiralMatrixII();
		sm.generateMatrix(3);
	}
}
