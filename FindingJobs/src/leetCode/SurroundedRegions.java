package leetCode;

public class SurroundedRegions {
	public void solve(char[][] board) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
		if(board==null) return;
		if(board.length==0){
			return;
		}
		if(board[0].length==0){
			return ;
		}
        for(int i=0;i<board.length;i++){
        	if(board[i][0]=='O'){
        		dfs(i,0,board);
        	}
        	if(board[i][board[0].length-1]=='O'){
        		dfs(i,board[0].length-1,board);
        	}
        }
        for(int i=0;i<board[0].length;i++){
        	if(board[0][i]=='O'){
        		dfs(0,i,board);
        	}
        	if(board[board.length-1][i]=='O'){
        		dfs(board.length-1,i,board);
        	}
        }
        
        for(int i=0;i<board.length;i++){
        	for(int j=0;j<board[0].length;j++){
        		if(board[i][j]!='m'){
        			board[i][j]='X';
        		}else{
        			board[i][j]='O';
        		}
        	}
        }
    }
	
	public void dfs(int i,int j,char[][] board){
		if(board[i][j]=='X'){
			return;
		}else if(board[i][j]=='m'){
			return;
		}
		board[i][j] = 'm';
		if(fit(i-1,j,board)){
			dfs(i-1,j,board);
		}
		if(fit(i+1,j,board)){
			dfs(i+1,j,board);
		}
		if(fit(i,j-1,board)){
			dfs(i,j-1,board);
		}
		if(fit(i,j+1,board)){
			dfs(i,j+1,board);
		}
	}
	
	public boolean fit(int i,int j,char[][] board){
		if(i>=0 && i<board.length && j>=0 && j<board[0].length){
			return true;
		}
		return false;
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
