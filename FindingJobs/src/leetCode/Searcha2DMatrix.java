package leetCode;

public class Searcha2DMatrix {
	public boolean searchMatrix(int[][] matrix, int target) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
		int begin = 0;
		int end = matrix.length*matrix[0].length-1;
		
		while(begin <= end){
			int mid = (begin+end)/2;
			if(this.getValue(mid, matrix) == target){
				return true;
			}else if(this.getValue(mid, matrix) < target){
				begin = mid+1;
			}else{
				end = mid -1;
			}
		}
		return false;
    }
	
	public int getValue(int pos,int[][] matrix){
		return matrix[this.getRow(pos, matrix.length, matrix[0].length)][this.getColumn(pos, matrix.length, matrix[0].length)];
	}
	
	public int getRow(int target,int m,int n){
			return target/n;
	}
	
	public int getColumn(int target,int m,int n){
			return target%n;
	}
	
	public static void main(String[] args){
		Searcha2DMatrix sm = new Searcha2DMatrix();
		int[][] tmp = {{1,3,5,7},{10,11,16,20},{23,30,34,50}};
		
		System.out.println(sm.searchMatrix(tmp, 2));
	}
	
}
