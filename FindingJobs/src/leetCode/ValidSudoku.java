package leetCode;

public class ValidSudoku {
	
	public boolean isValidSudoku(char[][] board) {
		for(int i=0;i<9;i++){
			if(!judgeCR(i,board)){
				return false;
			}
		}
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				if(!judgeCR(i*3,j*3,board)){
					return false;
				}
				
			}
		}
		return true;
    }
	
	public boolean judgeCR(int a,char[][] board){
		boolean[] appear = new boolean[9];
		for(int i=0;i<9;i++){
			if(board[i][a]!='.'){
				if(appear[board[i][a]-1-'0'] == false){
					appear[board[i][a]-1-'0'] = true;
				}else{
					return false;
				}
			}
		}
		appear = new boolean[9];
		for(int i=0;i<9;i++){
			if(board[a][i]!='.'){
				if(appear[board[a][i]-1-'0'] == false){
					appear[board[a][i]-1-'0'] = true;
				}else{
					return false;
				}
			}
		}
		return true;
	}
	
	public boolean judgeCR(int m,int n,char[][] board){
		
		boolean[] appear = new boolean[9];
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				if(board[m+i][n+j]=='.') continue;
				if(appear[board[m+i][n+j]-'0'-1] == false){
					appear[board[m+i][n+j]-'0'-1] = true;
				}else{
					return false;  
				}
			}
		}
		return true;
	}
	
	public static void main(String args[]){
		
	}
}
