package leetCode;

public class SurroundedRegions {
	public void solve(char[][] board) {
		if(board ==null || board.length==0){
			return ;
		}
		char[][] result = new char[board.length][board[0].length];
		for(int i=0;i<board.length;i++){
			result[i] = board[i].clone();
		}
		for(int )
	}
	
	
	
	
	public static void main(String args[]){
		SurroundedRegions sr = new SurroundedRegions();
		char[][] result = {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
//		char[][] result = {{}};

		sr.solve(result);
		for(int i=0;i<result.length;i++){
			for(int j=0;j<result[0].length;j++){
				System.out.print(result[i][j]);
			}
			System.out.println();
		}
	}
}
