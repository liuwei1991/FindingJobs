package leetCode;

public class RotateImage {
	public void rotate(int[][] matrix) {
		if(matrix==null){
			return ;
		}
		if(matrix.length==0){
			return;
		}
		int len = matrix.length;
		int n = len;
		for(int i=0;i<(len+1)/2;i++){
			for(int j=i;j<len-1-i;j++){
				int backUp = matrix[i][j];
				matrix[i][j] = matrix[len-j-1][i];
				matrix[len-j-1][i] = matrix[len-i-1][len-j-1];
				matrix[len-i-1][len-j-1] = matrix[j][len-i-1];
				matrix[j][len-i-1] = backUp;
			}
		}
		len = 1;
    }
	
	public static void main(String[] args){
		RotateImage ri = new RotateImage();
		int matrix[][] = {{1,2,3},{5,6,7},{9,10,11}};
//		int matrix[][] = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		ri.rotate(matrix);
	}
}
